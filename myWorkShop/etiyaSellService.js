export default class EtiyaSellService{
  
    constructor(){
        this.sells=[]
    }
    


    addSell(value,game){
        if(typeof(value=="object")){
            if(game.gameAge>value.personAge){
                console.log("Satın alınamadı")

            }else{
            this.sells.push(value)
            console.log("Satın alındı")
        }
        
            
    }
}
   

    getSell(){
        return sells;
    }
           
       

}
