const getData = async () => {
    try {
        const response = await fetch("https://api-to-call.com/endpoint", {method: "POST", body: JSON.stringify({id: 200})});
        if (response.ok) {
            return await response.json();
        }
        throw new Error('Request failed!');
    }
    catch (error) {
        console.log(error);
    }
}