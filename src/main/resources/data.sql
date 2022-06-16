DELETE FROM product_categories;
DELETE FROM category;
DELETE FROM invoice_line;
DELETE FROM product;
DELETE FROM invoice;
DELETE FROM customer;
DELETE FROM address;

INSERT INTO address (STREET,STREET_NUMBER,CITY,ZIP_CODE,COUNTRY) VALUES
                                                                     ('Trust Road','926','Hastings','4178','New Zealand'),
                                                                     ('Somewhere Street',NULL,'New York','10005','United States'),
                                                                     ('Thames Street','25B','London','SE10 9DD','United Kingdom');

INSERT INTO customer (NAME,ID_ADDRESS) VALUES
                                           ('John Doe',(select ID from address where ZIP_CODE='4178')),
                                           ('Mike Myers',(select ID from address where ZIP_CODE='10005')),
                                           ('Benny Hill',(select ID from address where ZIP_CODE='SE10 9DD'));



INSERT INTO category (NAME) VALUES
                                ('Fragile'),
                                ('Hi-Tech'),
                                ('Outdoor'),
                                ('Kitchenware');

INSERT INTO product (NAME) VALUES
                               ('Picnic Forks'),
                               ('Smartphone'),
                               ('Autonomous Lawn Mower'),
                               ('Mirror');

INSERT INTO product_categories (ID_PRODUCT,ID_CATEGORY) VALUES
                                                          ((select ID from product where NAME='Picnic Forks'),(select ID from category where NAME='Kitchenware')),
                                                          ((select ID from product where NAME='Picnic Forks'),(select ID from category where NAME='Outdoor')),
                                                          ((select ID from product where NAME='Smartphone'),(select ID from category where NAME='Hi-Tech')),
                                                          ((select ID from product where NAME='Smartphone'),(select ID from category where NAME='Fragile')),
                                                          ((select ID from product where NAME='Autonomous Lawn Mower'),(select ID from category where NAME='Outdoor')),
                                                          ((select ID from product where NAME='Autonomous Lawn Mower'),(select ID from category where NAME='Hi-Tech')),
                                                          ((select ID from product where NAME='Mirror'),(select ID from category where NAME='Fragile'));

INSERT INTO invoice (ORDER_NUMBER,ID_CUSTOMER) VALUES
                                                   ('AA123456789A',(select ID from customer where NAME='John Doe')),
                                                   ('AA123456789B',(select ID from customer where NAME='John Doe')),
                                                   ('BB123456789A',(select ID from customer where NAME='Mike Myers')),
                                                   (NULL,(select ID from customer where NAME='Benny Hill'));

INSERT INTO invoice_line (ID_PRODUCT,QUANTITY,INVOICE_NUMBER) VALUES
                                                                  ((select ID from product where NAME='Picnic Forks'),10,(select INVOICE_NUMBER from invoice where ORDER_NUMBER='AA123456789A')),
                                                                  ((select ID from product where NAME='Autonomous Lawn Mower'),1,(select INVOICE_NUMBER from invoice where ORDER_NUMBER='AA123456789A')),
                                                                  ((select ID from product where NAME='Smartphone'),1,(select INVOICE_NUMBER from invoice where ORDER_NUMBER='AA123456789B')),
                                                                  ((select ID from product where NAME='Picnic Forks'),22,(select INVOICE_NUMBER from invoice where ORDER_NUMBER='BB123456789A')),
                                                                  ((select ID from product where NAME='Mirror'),2,(select INVOICE_NUMBER from invoice where ORDER_NUMBER='BB123456789A')),
                                                                  ((select ID from product where NAME='Picnic Forks'),5,(select INVOICE_NUMBER from invoice where ORDER_NUMBER IS NULL));