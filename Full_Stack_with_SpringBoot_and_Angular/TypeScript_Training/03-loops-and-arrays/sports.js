var sportsOne = ["Golf", "Cricket", "Tennis", "Swimming"];
// for(let i = 0; i < sportsOne.length; i++) {
//     console.log(sportsOne[i]);
// }
// lets use forEach loop
for (var _i = 0, sportsOne_1 = sportsOne; _i < sportsOne_1.length; _i++) {
    var sport = sportsOne_1[_i];
    if (sport == "Cricket")
        console.log(sport + " << My Favourite");
    else
        console.log(sport);
}
