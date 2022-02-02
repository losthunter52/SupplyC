-- -----------------------------------------------------
-- Schema exemplo
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `exemplo` ;

-- -----------------------------------------------------
-- Schema exemplo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 ;

USE `exemplo` ;
select * from itensLocacao inner join filme on itensLocacao.filme_idFilme=filme.idFilmer;
-- -----------------------------------------------------
-- Table `exemplo`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplo`.`cliente` ;

CREATE TABLE IF NOT EXISTS `exemplo`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `dataCadastro` DATETIME NULL,
  `statusTupla` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idCliente_UNIQUE` ON `exemplo`.`cliente` (`idCliente` ASC);

-- -----------------------------------------------------
-- Table `exemplo`.`locacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplo`.`locacao` ;

CREATE TABLE IF NOT EXISTS `exemplo`.`locacao` (
  `idLocacao` INT NOT NULL AUTO_INCREMENT,
  `cliente_idCliente` INT NOT NULL,
  `dataLocacao` DATETIME NULL,
  `dataDevolucao` DATETIME NULL,
  `valor` DOUBLE NOT NULL,
  `statusTupla` SMALLINT NOT NULL DEFAULT 1,
  `emprestado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idLocacao`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idLocacao_UNIQUE` ON `exemplo`.`locacao` (`idLocacao` ASC);

-- -----------------------------------------------------
-- Table `exemplo`.`filme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplo`.`filme` ;

CREATE TABLE IF NOT EXISTS `exemplo`.`filme` (
  `idFilme` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `genero` VARCHAR(255) NOT NULL,
  `produtora` VARCHAR(255) NOT NULL,
  `statusTupla` SMALLINT NOT NULL DEFAULT 1,
  `codigo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idFilme`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `codigo_UNIQUE` ON `exemplo`.`filme` (`codigo` ASC);

CREATE UNIQUE INDEX `idFilme_UNIQUE` ON `exemplo`.`filme` (`idFilme` ASC);

-- -----------------------------------------------------
-- Table `exemplo`.`itensLocacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplo`.`itensLocacao` ;

CREATE TABLE IF NOT EXISTS `exemplo`.`itensLocacao` (
  `idItensLocacao` INT NOT NULL AUTO_INCREMENT,
  `locacao_idLocacao` INT NOT NULL,
  `filme_idFilme` INT NOT NULL,
  PRIMARY KEY (`idItensLocacao`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idItensLocacao_UNIQUE` ON `exemplo`.`itensLocacao` (`idItensLocacao` ASC);

-- -----------------------------------------------------
-- Table `exemplo`.`perfilUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplo`.`perfilUsuario` ;

CREATE TABLE IF NOT EXISTS `exemplo`.`perfilUsuario` (
  `idPerfilUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `statusTupla` SMALLINT NOT NULL DEFAULT 1,
  `dataCadastro` DATETIME NULL,
  PRIMARY KEY (`idPerfilUsuario`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idperfilUsuario_UNIQUE` ON `exemplo`.`perfilUsuario` (`idPerfilUsuario` ASC);

-- -----------------------------------------------------
-- Table `exemplo`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exemplo`.`usuario` ;

CREATE TABLE IF NOT EXISTS `exemplo`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` BLOB NOT NULL,
  `statusTupla` SMALLINT NOT NULL DEFAULT 1,
  `perfilUsuario_idPerfilUsuarioredesolidariedade_item` INT NOT NULL,
  `dataCadastro` DATETIME NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idusuario_UNIQUE` ON `exemplo`.`usuario` (`idUsuario` ASC);


USE `exemplo`;

DELIMITER $$

DROP TRIGGER IF EXISTS `exemplo`.`dataCadastro` $$
CREATE TRIGGER dataCadastro BEFORE INSERT ON cliente FOR EACH ROW SET NEW.dataCadastro = NOW()$$

DROP TRIGGER IF EXISTS `exemplo`.`dataLocacaoDevolucao` $$
CREATE TRIGGER dataLocacaoDevolucao BEFORE INSERT ON locacao FOR EACH ROW SET NEW.dataLocacao = NOW(), NEW.dataDevolucao = ADDDATE(NOW(), INTERVAL 5 DAY)$$

DROP TRIGGER IF EXISTS `exemplo`.`dataCadastroPerfilUsuario` $$
CREATE TRIGGER dataCadastroPerfilUsuario BEFORE INSERT ON perfilUsuario FOR EACH ROW SET NEW.dataCadastro = NOW()$$

DROP TRIGGER IF EXISTS `exemplo`.`dataCadastroUsuario` $$
CREATE TRIGGER dataCadastroUsuario BEFORE INSERT ON usuario FOR EACH ROW SET NEW.dataCadastro = NOW()$$

DELIMITER ;

