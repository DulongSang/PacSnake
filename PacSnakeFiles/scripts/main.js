var config = {
    type: Phaser.AUTO,
    width: 800,
    height: 800,
    physics: {
        default: 'arcade',
        arcade: {
            gravity: { y: 0 },
            debug: false
        }
    },
    scene: {
        preload: preload,
        create: create,
        update: update
    }
};

//let platforms;
let score;
let scoreText;
let cursors;
let maxCoordX = 80;
let maxCoordY = 80;

let game = new Phaser.Game(config);

function preload() {
    this.load.image("cyanBlock", "assets/CyanBlock.png");
    this.load.image("redBlock", "assets/RedBlock.png");
    this.load.image("blueBlock", "assets/BlueBlock.png");
}


function create() {
    //platforms = this.physics.add.staticGroup();
    
    scoreText = this.add.text(16, 16, 'Score: 0', { fontSize: '32px', fill: '#fff' });
    scoreText.setScrollFactor(0);

    //let levelWidth = 2000;
    //let levelHeight = 2000;
    //this.physics.world.bounds.width = levelWidth;
    //this.physics.world.bounds.height = levelHeight;

    // setup keyboard collection object
    cursors = this.input.keyboard.createCursorKeys();

    this.player = new Snake(40, 40, this);

    for (let i = 0; i < 10; i++)
        this.player.move();

    // setup cameron following
    //this.cameras.main.startFollow(this.player, true, 0.1, 0.1);
    //this.cameras.main.setBounds(0, 0, levelWidth, levelHeight);
    //this.cameras.main.setDeadzone(50, 50);
    //this.cameras.main.setBackgroundColor('#E3E3E3');

}

function update() {
    // update player's direction
    if (cursors.left.isDown) {
        this.player.updateDirection(new Vector2(-1, 0));
    } else if (cursors.right.isDown) {
        this.player.updateDirection(new Vector2(1, 0));
    } else if (cursors.up.isDown) {
        this.player.updateDirection(new Vector2(0, 1));
    } else if (cursors.down.isDown) {
        this.player.updateDirection(new Vector2(0, -1));
    }
}


function spawnFood() {

}