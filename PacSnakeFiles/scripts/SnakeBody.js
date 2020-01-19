class SnakeBody {
    constructor(position, game) {
        this.position = position;
        this.sprite = game.physics.add.sprite(position.toWorldX(), position.toWorldY(), "blueBlock");
    }

    translate(newPosition) {
        this.position = newPosition;
        this.sprite.x = this.position.toWorldX();
        this.sprite.y = this.position.toWorldY();
    }
}