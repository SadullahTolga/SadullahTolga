#!/usr/bin/env python
# coding: utf-8

# In[1]:


import warnings
import itertools
import numpy as np
import matplotlib.pyplot as plt
warnings.filterwarnings("ignore")
plt.style.use('fivethirtyeight')
import pandas as pd
import statsmodels.api as sm
import matplotlib
matplotlib.rcParams['axes.labelsize'] = 14
matplotlib.rcParams['xtick.labelsize'] = 12
matplotlib.rcParams['ytick.labelsize'] = 12
matplotlib.rcParams['text.color'] = 'k'


# In[2]:


# Verimizde birden fazla kategori var , biz Furniture kategorisi için zaman serisi analizi ve tahminimizi yapacağız.
# I.Adım olarak verimizi pandas kütüphanesi ile okutuyoruz.
df = pd.read_excel("C:/Users/Sado/Desktop/SADO/Python Çalışma/Python Forecasting and Time Series/Sample - Superstore.xls")


# In[3]:


#II.adım olarak veri içerisindeki furniture rahat erişebilmek için şöyle bir yol izliyoruz.
furniture = df.loc[df['Category'] == 'Furniture']


# In[4]:


# 4 yıllık bir Furniture verisine sahibiz
furniture['Order Date'].min(), furniture['Order Date'].max()


# In[5]:


#Bu kısımda ihtiyacımız olmayan verileri kaldırıyoruz ve kayıp veri kontrolü yapıyoruz.
cols = ['Row ID', 'Order ID', 'Ship Date', 'Ship Mode', 'Customer ID', 'Customer Name', 'Segment', 'Country', 'City', 'State', 'Postal Code', 'Region', 'Product ID', 'Category', 'Sub-Category', 'Product Name', 'Quantity', 'Discount', 'Profit']
furniture.drop(cols, axis=1, inplace=True)
furniture = furniture.sort_values('Order Date')
furniture.isnull().sum()


# In[6]:


#Elimizdeki mevcut veri ile çalışmak zor olabileceğini düşündüğümüz için ayların ortalama günlük satış değerlerini kullanacağız ve zamanları her ayın başlangıcı olarak kabul edeceğiz.
furniture = furniture.groupby('Order Date')['Sales'].sum().reset_index()


# In[7]:


furniture = furniture.set_index('Order Date')
furniture.index


# In[8]:


y = furniture['Sales'].resample('MS').mean()


# In[9]:


#Yukarıda demek istediğim aslında verilerimizin aylık ortalamasına göre her ayın başlangıcı olarak düzenledik.
#Aşağıdaki örnekte ne demek istediğimi daha rahat bir şekilde görebilirsiniz.
y['2017':]


# In[10]:


#Yukarıdaki bahsettiğimiz olarak görselleştirelim.
#Aşağıdaki grafiğe baktığımızda bazı gözle görülebilir desenler ortaya çıkıyor.
#Örneğin satışların yılın başında her zaman düşük ve yılın sonunda her zaman yüksek olması gibi.
#Zaman serisi mevsimselliğe sahiptir.Yılın ortasında birkaç düşük ay ile herhangi bir yıl içinde her zaman yükseliş trendi vardır.
y.plot(figsize=(15, 6))
plt.show()


# In[11]:


#Ayrıca verimizi  üç farklı zaman serisi ayrıştırma yöntemi olarak da görselleştirebiliriz.
#Bunlar trend , mevsimsellik , akgürültü
from pylab import rcParams
rcParams['figure.figsize'] = 18, 8
decomposition = sm.tsa.seasonal_decompose(y, model='additive')
fig = decomposition.plot()
plt.show()
#Bunlara baktığımızda açıkca görüyoruz ki verimiz hem dengesiz hem de  mevsimselliğe sahip


# In[12]:


#Şimdi sırada ARIMA ile Zaman Serisi Tahmini var.
#Zaman Serisi Tahminlerini yaparken en çok yaygın olaran methodlardan bir tanesi olan ARIMA'yı kullanacağız.
#ARIMA(p,d,q) buradaki parametreler mevsimsellik , trend ve akgürültü için
p = d = q = range(0, 2)
pdq = list(itertools.product(p, d, q))
seasonal_pdq = [(x[0], x[1], x[2], 12) for x in list(itertools.product(p, d, q))]
print('Examples of parameter combinations for Seasonal ARIMA...')
print('SARIMAX: {} x {}'.format(pdq[1], seasonal_pdq[1]))
print('SARIMAX: {} x {}'.format(pdq[1], seasonal_pdq[2]))
print('SARIMAX: {} x {}'.format(pdq[2], seasonal_pdq[3]))
print('SARIMAX: {} x {}'.format(pdq[2], seasonal_pdq[4]))


# In[13]:


#Bu adım en iyi modelimiz hangisi olduğunu bulmak için Akaike information criterion-AIC değerlerini hesaplayacağız.
for param in pdq:
    for param_seasonal in seasonal_pdq:
        try:
            mod = sm.tsa.statespace.SARIMAX(y,order=param,seasonal_order=param_seasonal,enforce_stationarity=False,enforce_invertibility=False)
            results = mod.fit()
            print('ARIMA{}x{}12 - AIC:{}'.format(param, param_seasonal, results.aic))
        except:
            continue


# In[25]:


#Yukarıya baktığımızda en uygun modelin SARIMAX(1,1,1)x(1,1,0,12) olduğunu görüyoruz çünkü AIC değeri en küçük olan (297.78) modelimiz budur.
#Modelimizi işleme koyalım.
mod = sm.tsa.statespace.SARIMAX(y,order=(1, 1, 1),seasonal_order=(1, 1, 0, 12),enforce_stationarity=False,enforce_invertibility=False)
results = mod.fit()
print(results.summary().tables[1])


# In[30]:


#Normalliği kontrol etmemiz lazım.
results.plot_diagnostics(figsize=(16,8)) 
plt.show()
#Modelimiz mükemmel değil ama normalliğe yakın bir davranış sergiliyor.


# In[31]:


#Tahminlerimizi anlamak için kendi öngörümüz ile gerçek veriyi karşılaştırmak için bir girişimde bulunalım.
pred = results.get_prediction(start=pd.to_datetime('2017-01-01'), dynamic=False)
pred_ci = pred.conf_int()
ax = y['2014':].plot(label='observed')
pred.predicted_mean.plot(ax=ax, label='One-step ahead Forecast', alpha=.7, figsize=(14, 7))
ax.fill_between(pred_ci.index,
                pred_ci.iloc[:, 0],
                pred_ci.iloc[:, 1], color='k', alpha=.2)
ax.set_xlabel('Date')
ax.set_ylabel('Furniture Sales')
plt.legend()
plt.show()
#Grafiğe baktığımzda tahminleriminiz gerçek gözlemle çok iyi uyum içinde olduğunu görebiliyoruz.


# In[32]:


y_forecasted = pred.predicted_mean
y_truth = y['2017-01-01':]
mse = ((y_forecasted - y_truth) ** 2).mean()
print('The Mean Squared Error of our forecasts is {}'.format(round(mse, 2)))
#MSE bir tahmin edicinin kalite ölçüsüdür ve ne kadar küçük olursa o kadar iyidir


# In[33]:


print('The Root Mean Squared Error of our forecasts is {}'.format(round(np.sqrt(mse), 2)))
#RMSE bize şunu söylüyor modelimizin günlük mobilya satışlarının gerçek satışlarin 151.64 'ü içinde tahmin yaptığını söylüyor'


# In[35]:


#Tahminlerin üretilmesi ve görselleştirilmesi
pred_uc = results.get_forecast(steps=100)
pred_ci = pred_uc.conf_int()
ax = y.plot(label='observed', figsize=(14, 7))
pred_uc.predicted_mean.plot(ax=ax, label='Forecast')
ax.fill_between(pred_ci.index,
                pred_ci.iloc[:, 0],
                pred_ci.iloc[:, 1], color='k', alpha=.25)
ax.set_xlabel('Date')
ax.set_ylabel('Furniture Sales')
plt.legend()
plt.show()
#Modelimiz mobilya satışlarının mevsimselliğini net bir şekilde yakalımıştır.

