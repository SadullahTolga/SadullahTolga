export default class UserService{
    constructor(){
        this.users=[]

    }
    userAdd(user){
        if(typeof(user=="object")){
            this.users.push(user)
            console.log("Bu " + user.userName + " kullanıcı sisteme eklendi.")
        } else{
            console.log("Lütfen doğru bilgi girin.")
        }
    }
    getUsers(){
        console.log("Kullanıcı listesi:")
        return this.users;
    }

    deleteUser(user){
        console.log("Silmek istediğiniz kişiyi seçin:")
        for(let i=0; i<this.users.length;i++){
            if(this.users[i].userId===user.userId){
                this.users.slice(i,1)
            }
        }
    }
}