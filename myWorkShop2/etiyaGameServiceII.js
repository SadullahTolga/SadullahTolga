import { games2 } from "../myWorkShop2/game2.js";
import DataError from "../models/dataError.js";



export default class EtiyaGameServiceII {
    constructor() {

        this.arcadeGames = [];
        this.strategyGames = [];
        this.error = [];

    }

    load() {
        for (let game of games2) {
            switch (game.gameType) {
                case "Arcade":
                    if (this.validateGame(game) && this.sameName(game)) {
                        this.arcadeGames.push(game)
                    }

                    break;
                case "Strategy":
                    if (this.validateGame(game)&&this.sameName(game)) {
                        this.strategyGames.push(game)
                    }

                    break;
                default:
                    this.error.push("Invalid data...", game)
                    break;
            }

        }
    }

    validateGame(game) {
        let requiredFile = ["gameId", "gameName", "gamePrice", "gameType"]
        let hasError = false;

        for (let file of requiredFile) {
            if (!game[file]) {
                this.errors.push("Invalid data...", game)
                hasError = true;
                    
                }
                
            }
       

        return !hasError;

    }


    sameName(game) {
        let hasErrors = false;
        for (let i=0; i<games2.length;i++) {
            if (game.gameName === games2[i].gameName && games2.indexOf(game) != i) {
                this.error.push("Invalid data...", game)
                games2.splice(i,1)
                hasErrors = true;
                if(game.gameType==="Strategy"){
                    this.strategyGames.push(game)
                }

                else if(game.gameType==="Arcade"){
                   this.arcadeGames.push(game)
               }
        }
        
    }
    return !hasErrors;
}
}
