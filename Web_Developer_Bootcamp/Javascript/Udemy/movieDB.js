var movieDB = {};

movieDB.movies = 
[
    {
        title: "The Godfather", 
        rating: 5,
        hasWatched: true
    }, 
    {
        title: "The Way Back", 
        rating: 4.5,
        hasWatched: false
    }, 
    {
        title: "The Shawshank Redemption", 
        rating: 5,
        hasWatched: true
    },
    {
        title: "Interstellar", 
        rating: 4,
        hasWatched: false
    }
]

movieDB.buildString = function() {
    let result = "You have ";
    this.movies.forEach(function(movie) {
        let suffix = movie.title+" - "+movie.rating+" stars";
        if (movie.hasWatched)
            result += "watched "
        else 
            result += "not seen "
        console.log(result + suffix); 
    });
}

movieDB.buildString();