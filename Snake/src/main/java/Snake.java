import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

// Main game class
public class Snake extends JPanel implements ActionListener, KeyListener {

    // Game constants (board size, tile size, initial speed, etc.)
    private final int BOARD_WIDTH = 600;
    private final int BOARD_HEIGHT = 600;
    private final int TILE_SIZE = 20;
    private Timer timer;
    private int delay = 100; // Game speed

    // Snake properties
    private LinkedList<Point> snake;
    private Point food;
    private Direction direction = Direction.RIGHT;
    private boolean gameOver = false;
    private int score = 0;

    public Snake() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        initGame();
    }

    private void initGame() {
        snake = new LinkedList<>();
        snake.add(new Point(5 * TILE_SIZE, 5 * TILE_SIZE)); // Initial head position
        generateFood();
        timer = new Timer(delay, this);
        timer.start();
    }

    private void generateFood() {
        Random rand = new Random();
        int foodX, foodY;
        do {
            foodX = rand.nextInt(BOARD_WIDTH / TILE_SIZE) * TILE_SIZE;
            foodY = rand.nextInt(BOARD_HEIGHT / TILE_SIZE) * TILE_SIZE;
            food = new Point(foodX, foodY);
        } while (snake.contains(food)); // Ensure food doesn't spawn on snake
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (!gameOver) {
            // Draw food
            g.setColor(Color.RED);
            g.fillRect(food.x, food.y, TILE_SIZE, TILE_SIZE);

            // Draw snake
            for (Point segment : snake) {
                g.setColor(Color.GREEN);
                g.fillRect(segment.x, segment.y, TILE_SIZE, TILE_SIZE);
            }

            // Draw score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + score, 10, 25);
        } else {
            // Game Over screen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Game Over", (BOARD_WIDTH - metrics.stringWidth("Game Over")) / 2, BOARD_HEIGHT / 2);
            g.drawString("Score: " + score, (BOARD_WIDTH - metrics.stringWidth("Score: " + score)) / 2, BOARD_HEIGHT / 2 + 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            checkCollision();
            checkFood();
        }
        repaint();
    }

    private void move() {
        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case UP:
                newHead.y -= TILE_SIZE;
                break;
            case DOWN:
                newHead.y += TILE_SIZE;
                break;
            case LEFT:
                newHead.x -= TILE_SIZE;
                break;
            case RIGHT:
                newHead.x += TILE_SIZE;
                break;
        }
        snake.addFirst(newHead);
        snake.removeLast(); // Remove tail unless growing
    }

    private void checkCollision() {
        Point head = snake.getFirst();

        // Wall collision
        if (head.x < 0 || head.x >= BOARD_WIDTH || head.y < 0 || head.y >= BOARD_HEIGHT) {
            gameOver = true;
        }

        // Self-collision
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                gameOver = true;
                break;
            }
        }
    }

    private void checkFood() {
        Point head = snake.getFirst();
        if (head.equals(food)) {
            score++;
            snake.addLast(snake.getLast()); // Grow the snake
            generateFood();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (direction != Direction.RIGHT)) {
            direction = Direction.LEFT;
        }
        if ((key == KeyEvent.VK_RIGHT) && (direction != Direction.LEFT)) {
            direction = Direction.RIGHT;
        }
        if ((key == KeyEvent.VK_UP) && (direction != Direction.DOWN)) {
            direction = Direction.UP;
        }
        if ((key == KeyEvent.VK_DOWN) && (direction != Direction.UP)) {
            direction = Direction.DOWN;
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Snake game = new Snake();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

enum Direction {
    UP, DOWN, LEFT, RIGHT
}