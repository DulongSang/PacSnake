class Vector2 {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    toWorldX() {
        return this.x * 10;
    }

    toWorldY() {
        return this.y * 10;
    }

    toString() {
        return "Vector2 (" + this.x + ", " + this.y + ")";
    }
}