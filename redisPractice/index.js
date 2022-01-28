const express = require("express");
const redis = require("redis");
const fetch = require("node-fetch");


const PORT = process.env.PORT || 5000;
const REDIS_PORT = process.env.PORT || 6379;

const client = redis.createClient(REDIS_PORT);
const app = express();

async function getReposne(req, res, next) {
    try {
        console.log("fetching data..");
        const { username } = req.params;

        const response = await fetch(`https://api.github.com/users/${username}`);
        const data = await response.json();
        const repos = data.public_repos;

        client.setex(username, 3600, repos);
        res.send(setResponse(usernmae, repos));
    } catch (err) {
        console.log(err);
    }
}

function setResponse(username, repos) {
    return `<h2>${username} has ${repos} repos</h2>`;
}

function cache(req, res, next) {
    const { username } = req.params;

    client.get(username, (err, data) => {
        if (err) {
            throw err;
        }

        if (data !== null) {
            res.send(setResponse(username, data));
        } else {
            next();
        }
    })
}

app.get('/repos/:username', cache, getReposne); 


app.listen(5000, () => {
    console.log("server is listening");
})