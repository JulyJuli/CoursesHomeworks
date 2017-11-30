INSERT INTO `test`.`book` (`idBook`, `Name`, `ISBN`) VALUES ('1', 'HIGH HOPES', '1479387576');
INSERT INTO `test`.`book` (`idBook`, `Name`, `ISBN`) VALUES ('2', 'CALUMET K', '1561141461');
INSERT INTO `test`.`book` (`idBook`, `Name`, `ISBN`) VALUES ('3', 'OLIVER TWIST', '1209574637');


INSERT INTO `test`.`category` (`idCategory`, `Name`) VALUES ('1', 'Fiction');
INSERT INTO `test`.`category` (`idCategory`, `Name`) VALUES ('2', 'Novel');


INSERT INTO `test`.`author` (`idAuthor`, `Name`) VALUES ('1', 'ERNEST HEMINGWAY');
INSERT INTO `test`.`author` (`idAuthor`, `Name`) VALUES ('2', 'CHARLES DICKENS');
INSERT INTO `test`.`author` (`idAuthor`, `Name`) VALUES ('3', 'AYN RAND');
INSERT INTO `test`.`author` (`idAuthor`, `Name`) VALUES ('4', 'F. SCOTT FITZGERALD');



INSERT INTO `test`.`book_has_category` (`Book_idBook`, `Category_idCategory`) VALUES ('2', '1');
INSERT INTO `test`.`book_has_category` (`Book_idBook`, `Category_idCategory`) VALUES ('1', '2');
INSERT INTO `test`.`book_has_category` (`Book_idBook`, `Category_idCategory`) VALUES ('3', '2');

INSERT INTO `test`.`book_has_author` (`Book_idBook`, `Author_idAuthor`) VALUES ('1', '2');
INSERT INTO `test`.`book_has_author` (`Book_idBook`, `Author_idAuthor`) VALUES ('3', '2');
INSERT INTO `test`.`book_has_author` (`Book_idBook`, `Author_idAuthor`) VALUES ('2', '3');
