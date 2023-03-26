/*GENERAL*/
CREATE DATABASE ElectronicHome;
\c electronichome;

/*SCHEMAS*/
CREATE SCHEMA tool;
CREATE SCHEMA officeControl;
CREATE SCHEMA humanResourcesControl;
CREATE SCHEMA customerControl;
CREATE SCHEMA goodsControl;
CREATE SCHEMA transactionControl;

/*//////////////////////////////////////*/

/*indicator*/
CREATE TABLE tool.Indexator{
    tableName VARCHAR(20) NOT NULL,
    prefix VARCHAR(10), /*like: OID, EOC, EON, EOS, EOT....*/
    indice INT8 NOT NULL,/*aunque unos incluyan letras, comohay un correlativo, lo mejor sería guardar el dato, luego pasarlo a string y addle el extra..*/
    /*el vlor que aquí aparezca +1 será el nuevo índice*/

    PRIMARY KEY(tableName, prefix)    
}

/*office*/
CREATE TABLE officeControl.Office(
    ID VARCHAR(25) NOT NULL,
    name VARCHAR(150) NOT NULL,
    adress VARCHAR(250) NOT NULL,

    PRIMARY KEY(ID)
);/*tb hay que incluir bodega, para no tener ninguna dificultad por la existencia de Stock...*/

\dt officeControl.*

/*//////////////////////////////////////*/

CREATE TABLE humanResourcesControl.Position(
    position VARCHAR(15) NOT NULL,
    payment DECIMAL(7,2) DEFAULT 3200    CHECK(payment >= 0) NOT NULL,/*deje 7, en lugar de 6, por si acso se req un espacio extra...*/

    PRIMARY KEY(position)
);/*New, and ready*/

/*employee*/
CREATE TABLE humanResourcesControl.Employee(
    ID VARCHAR(20) NOT NULL,/*este se ingresa desde la interfaz por el SHA... es imposible que se repita puesto que el CUI es unico aunqeu nombres se repitan*/
    CUI VARCHAR(30) NOT NULL, 
    name VARCHAR(200) NOT NULL,        
    password VARCHAR(75) NOT NULL,
    since DATE DEFAULT CURRENT_DATE /*NOT NULL, fecha general, sin importar cuantos contratos tenga... por lo cual NO se modificará*/,    
    hired BOOLEAN DEFAULT true,

    PRIMARY KEY(ID)
    FOREIGN KEY(position) REFERENCES humanResourcesControl.Position(position) ON UPDATE CASCADE ON DELETE CASCADE,
);/*puse cascade en delete, porque ya no exixtiría más eses puesto y como solo se borra el dato, entonces ta bien, porque ya solo debería asignar otro puesto si es el caso*/

/*contract*/
CREATE TABLE humanResourcesControl.Contract(
    ID SERIAL NOT NULL,/*sería mejor un VARCHAR, pero de ahí a que se alcance un millón está lejos... de todos modos se podría cb a VARCHAR si se req...*/
    employee VARCHAR(20) NOT NULL,/*que el ID del employee esté aquí está genial [mira nota]*/
    office VARCHAR(25),/*tb está bueno que no sea NOT NULL, porque el admin no tiene una tienda asignada*/
    position VARCHAR(15) NOT NULL,
    initialDate DATE DEFAULT CURRENT_DATE /*NOT NULL*/,
    dueDate DATE NOT NULL,    

    PRIMARY KEY(ID),
    FOREIGN KEY(employee) REFERENCES humanResourcesControl.Employee(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(office) REFERENCES officeControl.Office(ID) ON UPDATE CASCADE ON DELETE CASCADE/*el delete lo dejé en cascade, porque si están borrando una sucursal es porque ya no intersa más, entonces xD. de todos modos si se vuelven a contratar a los empleados, se les haría un nuevo contrato...*/
);

ALTER SEQUENCE humanResourcesControl.Contract.ID RESTART WITH 562355;

/*BUeno en realidad con lo de la oficina, ahora no se si se elimina una de llas, el registro entero se eliminaría o solo el atributo
  si es solo el atributo entonces no debería dejar el NOT NULL, pero si es todo, entonces eso está mal...*/
/*Como en el caso que el employee se eliminé no se va a borrar el dato de él, entonces el NOT NULL no afecta*/

\dt employeeControl.*/*to see every single table that are involve in this schema/scope*/

/*//////////////////////////////////////*/

/*customer*/
CREATE TABLE customerControl.Customer(
    NIT VARCHAR(25) NOT NULL,
    CUI VARCHAR(30) NOT NULL,
    name VARCHAR(50) NOT NULL,    
    address VARCHAR(250) NOT NULL,
    since DATE DEFAULT CURRENT_DATE /*NOT NULL*/,

    PRIMARY KEY(NIT)
);/*NO incluí el CUI, porque con el NIT basta, además si se quiere buscar en la agencia virtual, simplemente se puede pedir en el momento el CUI al respectivo cliente...*/

\dt customerControl.*

/*//////////////////////////////////////*/

/*mira justificación de por qué enum en las notas*/
/*brand*/
CREATE TYPE goodsControl.brand AS ENUM ('Samsung', 'LG Electronics', 'Haier', 'Frigidaire', 'Whirlpool', 'Oster', 'BLACK+DECKER', 'HP', 'Dell', 'ASUS', 'Xiaomi', 'Nintendo', 'Nikon', 'Cannon');/*new*/

/*clasification*/
CREATE TABLE goodsControl.Clasification{
    ID SERIAL,/*por defecto inicia en 1*/
    type VARCHAR(50) NOT NULL,/*estaba pensando en hacerlo con ENUM, pero así sería algo redundante, entonces mejor haré el INSERT directamente...*/
    line VARCHAR(15) NOT NULL,

    PRIMARY KEY(ID)
};/*new*/

/*appliance*/
CREATE TABLE goodsControl.Appliance(
    name VARCHAR(250) NOT NULL,
    theBrand brand NOT NULL,/*check*/
    clasification SERIAL NOT NULL,
    detail VARCHAR(255),
    /*bien podría haber agregado detalles, como para así
      especificar el tamño, color y eso. Pero no quiero xD*/

    PRIMARY KEY(name, theBrand),
    FOREIGN KEY(clasification) REFERENCES goodsControl.Clasification(ID) ON UPDATE CASCADE ON DELETE NO ACTION /*se queda, porque simplemente no se puede cb de clasi solo porque la tienda ya no lo vende...*/
);/*Aunque al momento de usar product, esta tabla solo me sirva para averiguar la categoría, voy a dejar la tabla, porque bien podría agregar o querer add un atributo/columna de garantía u otras cosas que pertenecen al appliance como tal y no al produto*/

/*product*/
CREATE TABLE goodsControl.Product(/*por el hecho que este no se repite por cada una de las existencias de un mismo producto es que INT8 es suficiente, porque a menos que se add != tipos hasta llear a 1 millón sería insuficiente, puesto que no importa cuantos haya de un mismo tipo pues se guardará bajo un mismo código*/
    code SERIAL NOT NULL,/*solo este tien NOT NULL, porque podría no existir, y como esto se debe mostrar en la interface, prevoi a ingresar lo demás...*/
    name VARCHAR(250),
    theBrand brand,
    price DECIMAL(8,2) CHECK(price >= 0),    

    PRIMARY KEY(code),
    FOREIGN KEY(name, theBrand) REFERENCES goodsControl.Appliance(name, theBrand) ON UPDATE CASCADE ON DELETE CASCADE,/*cascade, pues si ya no hay appliance, entonces ya no hay producto*/    
);

ALTER SEQUENCE goodsControl.Product.code RESTART WITH 1000000;

/*stock*/
CREATE TABLE goodsControl.Stock(
    ID VARCHAR(25) NOT NULL,
    product SERIAL NOT NULL,/*sin producto NO HAY stock*/
    quantity SMALLINT NOT NULL CHECK(quantity >= 0),
    office VARCHAR(25),

    PRIMARY KEY(ID),
    FOREIGN KEY(office) REFERENCES officeControl.Office(ID) ON UPDATE CASCADE ON DELETE CASCADE/*el delete lo dejé en cascade, porque si se elimina una sucursal, entonces obvi dobi ese stock ya no puede estar más allí*/
    FOREIGN KEY(product) REFERENCES officeControl.Product(code) ON UPDATE CASCADE ON DELETE CASCADE
);
/*quité el NOT NULL por lo mismo, que si se va una office, no tendría porque eli el stock sino solo cb de lugar*/
/*pero si se borarn todas las office, entonces todos los stock quedarían con eso vacío jaja, lo cual es cierto, pero en la DB no se si debería pasar xd*/

\dt goodsControl.*

/*//////////////////////////////////*/

/*sale*/
CREATE TABLE transactionControl.Sale(
    ID VARCHAR(30) NOT NULL,/*if you want to make it real, add SERIES*/
    office VARCHAR(25) NOT NULL, 
    tender VARCHAR(20) NOT NULL,
    customer VARCHAR(25) NOT NULL,
    salesDate DATE DEFAULT CURRENT_DATE /*NOT NULL*/,    
    disccount DECIMAL (3,2) DEFAULT 0 NOT NULL,/*este dato puede ser encontrado sin nec de SOLDs*/
    total DECIMAL(16,2) CHECK(total >= 0),/*quité el NOT NULL, puesto que se add luego de press PROCEED*/
    pastTotal DECIMAL(16,2) CHECK(total >= 0) DEFAULT 0,/*aunque como dije antes, creo que es redundante*/

    PRIMARY KEY(ID),
    FOREIGN KEY(office) REFERENCES officeControl.Office(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(tender) REFERENCES humanResourcesControl.Employee(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(customer) REFERENCES customerControl.Customer(NIT) ON UPDATE NO ACTION ON DELETE NO ACTION
);

/*sale*/
CREATE TABLE transactionControl.Sold(
    code VARCHAR(30) NOT NULL,/*este código será interno, no será PK porque se repetira, cada vez que se inicie otra venta y lo dejé puesto que de esa manera si un cliente o por alguna razón se quisiera ver los detalles de un producto en específico, entonces con esto se podría hacer más fácil (la tabal tendrá el # corresp y a partir de ahí se armará la QUERY para hallar el dato*/
    sale VARCHAR(30) NOT NULL,
    product SERIAL NOT NULL,
    quantity SMALLINT NOT NULL CHECK(cuantity >= 1) DEFAULT 1,
    subtotal DECIMAL(11,2) CHECK(subtotal >= 0) NOT NULL,/*tiene que se más que el producto claro xd*/

    PRIMARY KEY(code),/*en realidad no necesita una PK y bien podría quitar el campo pensaba hacer que fuera un código interno, pero para buscar no tendría mucho chiste, además con un correlativo general se podría obetner en el orden de ingreso claramente, entonces... xD*/
    FOREIGN KEY(sale) REFERENCES transactionControl.Sale(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,/*porque el útimo de estos va a ser borrado antes que la SALE*/
    FOREIGN KEY(product) REFERENCES goodsControl.Product(code) ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER SEQUENCE transactionControl.Sold.code RESTART WITH 12345;

CREATE TYPE transactionControl.state AS ENUM ('pending', 'read', 'processed', 'done');/*new*/

CREATE TABLE transactionControl.Transfer(
    ID VARCHAR(30) NOT NULL,
    transferState state DEFAULT 'pending' NOT NULL,/*ira cb según la interacción con la interfaz... solo done, tendrá botón para ser marcado...*/
    origin VARCHAR(25) NOT NULL,
    destiny VARCHAR(25) NOT NULL,
    since DATE DEFAULT CURRENT_DATE /*NUT NULL*/,
    until DATE NOT NULL,
    did DATE,/*caundo se transfirió, no nec cuando se Done*//*sin NOT NULL porque eso se seteará en un UPDATE...*/
    reason TEXT NOT NULL,/*text, permite que no se pierda el formato*/

    PRIMARY KEY(ID),
    FOREIGN KEY(origin) REFERENCES officeControl.Office(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(destiny) REFERENCES officeControl.Office(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE transactionControl.Transferred(
    code SERIAL NOT NULL,
    transfer VARCHAR(30) NOT NULL,
    product INT8 NOT NULL,
    requested INT2 CHECK(quantity >= 1) DEFAULT 1,
    sended INT2 CHECK(quantity >= 0),/*esto se llenará hasta que procese la solicitud*/

    PRIMARY KEY(code),
    FOREIGN KEY(transfer) REFERENCES transactionControl.Transfer(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(product) REFERENCES goodsControl.Product(code) ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER SEQUENCE transactionControl.Transfer.code RESTART WITH 757525;
    /*Y si lo vas a pasar a INDEXATOR, ahí vuelves el code, un VARCHAR...*/*/
\dt transactionControl.*


DROP TABLE productionControl.Sales;
DROP SCHEMA IF EXISTS productionControl;

DROP TABLE storageControl.Product;
DROP SCHEMA IF EXISTS storageControl;

DROP TABLE employeeControl.Employee;
DROP SCHEMA IF EXISTS employeeControl;

DROP DATABASE musicalStore;

/*WHEN CURRENT_DATE, pienso que no debería colocarse NOT NULL, pues porque xD*/