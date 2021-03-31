let sportsTwo: string[] = ["Golf", "Cricket", "Tennis", "Swimming"];

sportsTwo.push("BaseBall");
sportsTwo.push("FootBall");

for(let sport of sportsTwo) {
    console.log(sport);
}

// tsc --noEmitOnError <file.ts>