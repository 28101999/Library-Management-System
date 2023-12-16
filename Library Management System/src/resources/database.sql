-- Sample SQL script
CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255)
);

CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

-- Additional SQL statements

-- Table to track checked-out books
CREATE TABLE checked_out_books (
    id INT PRIMARY KEY,
    book_id INT,
    user_id INT,
    checkout_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table to track user history
CREATE TABLE user_history (
    id INT PRIMARY KEY,
    user_id INT,
    action VARCHAR(255),
    book_id INT,
    action_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Example trigger to log user actions
CREATE TRIGGER log_checkout
AFTER INSERT ON checked_out_books
FOR EACH ROW
INSERT INTO user_history (user_id, action, book_id, action_date)
VALUES (NEW.user_id, 'Checkout', NEW.book_id, NEW.checkout_date);

CREATE TRIGGER log_return
AFTER DELETE ON checked_out_books
FOR EACH ROW
INSERT INTO user_history (user_id, action, book_id, action_date)
VALUES (OLD.user_id, 'Return', OLD.book_id, CURDATE());
