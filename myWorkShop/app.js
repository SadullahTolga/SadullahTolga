import Game from "./myWorkShop/etiyaGames.js"
import GameService from "./myWorkShop/etiyaGameService.js"
import Users from "./myWorkShop/etiyaUsers.js"
import UserService from "./myWorkShop/etiyaUserService.js"
import Sell from "./myWorkShop/etiyaSell.js"
import SellService from "./myWorkShop/etiyaSellService.js"

let game1 = new Game(1,"Lord of the Rings",150,13,Strateji)
let game2 = new Game(1,"GTA",160,16,Strateji)
let game3 = new Game(1,"AGEOF",170,13,Strateji)
let game4 = new Game(1,"RDRII",180,17,Strateji)
let game5 = new Game(1,"God of War",190,18,Strateji)

let gameService = new GameService();

gameService.addGame(game1)
gameService.addGame(game2)
gameService.addGame(game3)
gameService.addGame(game4)
gameService.addGame(game5)
