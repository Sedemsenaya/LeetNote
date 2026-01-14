const express = require("express");
const mysql = require("mysql2/promise");
const cors = require("cors");
const path = require("path");


const app = express();
app.use(express.json());

// ✅ CORS (allow React dev server)
// app.use(cors({
//     // origin: "http://localhost:5173"
//     origin: "https://leetnote-backend-separate.onrender.com"
// }));

app.use(cors());

// 🔥 LOG EVERY REQUEST
app.use((req, res, next) => {
    console.log("➡️ Incoming:", req.method, req.url);
    next();
});

// MySQL pool
const db = mysql.createPool({
    host: "localhost",
    user: "root",
    password: "Seditech@25",
    database: "leetnotedb"
});

// Serve the "videos" folder statically
app.use('/videos', express.static(path.join(__dirname, 'videos')));

// Root
app.get("/", (req, res) => {
    res.send("Backend is alive 🚀");
});

// Problems
app.get("/problems", async (req, res) => {
    console.log("🔥 /problems HANDLER reached");
    const [rows] = await db.query(
        "SELECT id, Problem, Pattern, Note, Visualization, Difficulty FROM leetnote"
    );
    res.json(rows);
});

app.listen(3002, () => {
    console.log("Server running on http://localhost:3002");
});


app.get("/debug-videos-path", (req, res) => {
    res.send(path.join(__dirname, "videos"));
});