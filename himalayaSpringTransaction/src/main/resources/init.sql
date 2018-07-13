DROP TABLE tb_account;

CREATE TABLE `tb_account` (
	`account` CHAR (60),
	`amount` DECIMAL (11)
); 
INSERT INTO `tb_account` (`account`, `amount`) VALUES('Anna','1000');
INSERT INTO `tb_account` (`account`, `amount`) VALUES('Fred','1000');
INSERT INTO `tb_account` (`account`, `amount`) VALUES('Wendy','1000');

SELECT * FROM tb_account;