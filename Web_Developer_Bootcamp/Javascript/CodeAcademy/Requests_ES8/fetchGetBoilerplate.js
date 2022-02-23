const getData = async () => {
    try {
        const response = await fetch("https://api-to-call.com/endpoint");
        if (response.ok) {
            return await response.json();
        }
        throw new Error('Request failed!');
    } catch (error) {
        console.log(error);
    }
}