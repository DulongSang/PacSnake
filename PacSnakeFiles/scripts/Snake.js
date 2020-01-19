class Snake {
    bodyList = [];
    length = 1;
    direction = new Vector2(1, 0);  // default to left
    constructor(x, y, game) {
        this.position = new Vector2(x, y);
        this.game = game;
        this.sprite = game.physics.add.sprite(this.position.toWorldX(), this.position.toWorldY());
        //this.sprite.disableBody(true, true);
        this.bodyList.push(new SnakeBody(this.position, this.game));
    }

    move() {
        this.position += this.direction;
        let x = this.position.toWorldX();
        let y = this.position.toWorldY();
        this.sprite.x = x;
        this.sprite.y = y;
        this.bodyList[this.length-1].translate(x, y);
    }

    updateDirection(newDirection) {
        this.direction = newDirection;
    }

    addBody() {
        this.bodyList.push(new SnakeBody(this.bodyList[this.length-1].position, this.game));
        this.length += 1;
    }
}