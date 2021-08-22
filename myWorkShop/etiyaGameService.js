export default class EtiyaGameService{

    constructor(){
    this.games=[]

    }

    addGame(game){
        if(typeof(game=="object")){
        this.games.push(game)
        console.log(game.gameName)
        console.log("İstediğiniz oyun kütüphanenize eklendi.")
    }else{
        console.log("Lütfen doğru bilgi girin.")
    }
    }
    getGame(){
        console.log("Oyunlarınızın listesi:")
        return this.games;
    }

    deleteGame(game){
        for(let i=0;i<this.games.length;i++){
            if(this.games[i].gameId===game.gameId){
                this.games.slice(i,1)
            }

        }

    }
    countGame(){
        let count=this.games.length()
        return count;
    }
}