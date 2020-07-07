
db.createUser({
    user: "skoogleadmin",
    pwd: "53cr3t",
    roles: [{
        role: "readWrite",
        db: "skoogle-desktop"
    }]
})