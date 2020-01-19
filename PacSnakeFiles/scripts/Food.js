class Food {
    constructor(x, y, game) {
        this.position = new Vector2(x, y);
        this.sprite = game.physics.add.sprite(x, y, "cyanBlock");
    }
}