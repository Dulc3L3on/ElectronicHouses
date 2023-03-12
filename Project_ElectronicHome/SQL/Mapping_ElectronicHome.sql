/*GENERAL*/
CREATE DATABASE ElectronicHome;
\c electronichome;

/*SCHEMAS*/
CREATE SCHEMA officeControl;
CREATE SCHEMA humanResourcesControl;
CREATE SCHEMA customerControl;
CREATE SCHEMA goodsControl;
CREATE SCHEMA transactionControl;

/*//////////////////////////////////////*/

/*office*/
CREATE TABLE officeControl.Office(
    ID VARCHAR(25) NOT NULL,
    name VARCHAR(150) NOT NULL,
    adress VARCHAR(250) NOT NULL,

    PRIMARY KEY(ID)
);/*tb hay que incluir bodega, para no tener ninguna dificultad por la existencia de Stock...*/

\dt officeControl.*

/*//////////////////////////////////////*/

/*employee*/
CREATE TABLE humanResourcesControl.Employee(
    ID VARCHAR(15) NOT NULL,/*este se ingresa desde la interfaz por el SHA... es imposible que se repita puesto que el CUI es unico aunqeu nombres se repitan*/
    CUI INT8 NOT NULL, 
    name VARCHAR(25) NOT NULL,
    position VARCHAR(15) NOT NULL,
    since DATE DEFAULT CURRENT_DATE() NOT NULL,    

    PRIMARY KEY(ID)
    FOREIGN KEY(position) REFERENCES humanResourcesControl.Position(position) ON UPDATE CASCADE ON DELETE CASCADE,
);/*puse cascade en delete, porque ya no exixtiría más eses puesto y como solo se borra el dato, entonces ta bien, porque ya solo debería asignar otro puesto si es el caso*/

CREATE TABLE humanResourcesControl.Position(
    position VARCHAR(15) NOT NULL,
    payment INT2 NOT NULL CHECK(payment >= 0),

    PRIMARY KEY(position)
);/*New, and ready*/

/*contract*/
CREATE TABLE humanResourcesControl.Contract(
    ID INT8 NOT NULL,
    employee VARCHAR(15) NOT NULL,/*que el ID del employee esté aquí está genial [mira nota]*/
    office VARCHAR(25),
    initialDate DATE DEFAULT CURRENT_DATE() NOT NULL,
    dueDate DATE NOT NULL,

    PRIMARY KEY(ID),
    FOREIGN KEY(employee) REFERENCES humanResourcesControl.Employee(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(office) REFERENCES officeControl.Office(ID) ON UPDATE CASCADE ON DELETE CASCADE/*el delete lo dejé en cascade, porque si están borrando una sucursal es porque ya no intersa más, entonces xD. de todos modos si se vuelven a contratar a los empleados, se les haría un nuevo contrato...*/
);

/*BUeno en realidad con lo de la oficina, ahora no se si se elimina una de llas, el registro entero se eliminaría o solo el atributo
  si es solo el atributo entonces no debería dejar el NOT NULL, pero si es todo, entonces eso está mal...*/
/*Como en el caso que el employee se eliminé no se va a borrar el dato de él, entonces el NOT NULL no afecta*/

\dt employeeControl.*/*to see every single table that are involve in this schema/scope*/

/*//////////////////////////////////////*/

/*customer*/
CREATE TABLE customerControl.Customer(
    NIT VARCHAR(20) NOT NULL,
    name VARCHAR(50) NOT NULL,
    CUI INT8 NOT NULL,
    adress VARCHAR(250) NOT NULL,
    since DATE DEFAULT CURRENT_DATE(),

    PRIMARY KEY(NIT)
);/*NO incluí el CUI, porque con el NIT basta, además si se quiere buscar en la agencia virtual, simplemente se puede pedir en el momento el CUI al respectivo cliente...*/

\dt customerControl.*

/*//////////////////////////////////////*/

/*mira justificación de por qué enum en las notas*/
/*brand*/
CREATE TYPE brand AS ENUM ('Samsung', 'LG Electronics', 'Haier', 'Frigidaire', 'Whirlpool', 'General Electric', 'Miele');/*new*/

/*clasification*/
CREATE TABLE goodsControl.Clasification{
    ID INT2 SERIAL,/*pero no sé como decir que empiece en 1...*/
    type VARCHAR(20) NOT NULL,/*estaba pensando en hacerlo con ENUM, pero así sería algo redundante, entonces mejor haré el INSERT directamente...*/
    line VARCHAR(15) NOT NULL,

    PRIMARY KEY(ID)
};/*new*/

/*appliance*/
CREATE TABLE goodsControl.Appliance(
    name VARCHAR(50) NOT NULL,
    applianceBrand brand NOT NULL,/*check*/
    clasification INT2 NOT NULL,

    PRIMARY KEY(name, brand),
    FOREIGN KEY(clasification) REFERENCES goodsControl.Clasification(ID) ON UPDATE CASCADE ON DELETE NO ACTION /*se queda, porque simplemente no se puede cb de clasi solo porque la tienda ya no lo vende...*/
);/*Aunque al momento de usar product, esta tabla solo me sirva para averiguar la categoría, voy a dejar la tabla, porque bien podría agregar o querer add un atributo/columna de garantía u otras cosas que pertenecen al appliance como tal y no al produto*/

/*stock*/
CREATE TABLE goodsControl.Stock(
    ID VARCHAR(25) NOT NULL,
    cuantity SMALLINT NOT NULL CHECK(cuantity >= 0),
    office VARCHAR(25),

    PRIMARY KEY(ID),
    FOREIGN KEY(office) REFERENCES officeControl.Office(ID) ON UPDATE CASCADE ON DELETE CASCADE/*el delete lo dejé en cascade, porque si se elimina una sucursal, entonces obvi dobi ese stock ya no puede estar más allí*/
);
/*quité el NOT NULL por lo mismo, que si se va una office, no tendría porque eli el stock sino solo cb de lugar*/
/*pero si se borarn todas las office, entonces todos los stock quedarían con eso vacío jaja, lo cual es cierto, pero en la DB no se si debería pasar xd*/

/*product*/
CREATE TABLE goodsControl.Product(
    code INT8 NOT NULL,
    name VARCHAR(50) NOT NULL,
    brand VARCHAR(20) NOT NULL,
    stock VARCHAR(25),/*no deje el NOT NULL, porque si se borra un stock, entonces esto debería quedar vacío*/
    price DECIMAL(7,2) CHECK(price >= 0) NOT NULL,    

    PRIMARY KEY(code),
    FOREIGN KEY(name, brand) REFERENCES goodsControl.Appliance(name, brand) ON UPDATE CASCADE ON DELETE CASCADE,/*cascade, pues si ya no hay appliance, entonces ya no hay producto*/
    FOREIGN KEY(stock) REFERENCES goodsControl.Stock(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

\dt goodsControl.*

/*//////////////////////////////////*/

/*sale*/
CREATE TABLE transactionControl.Sale(
    code VARCHAR(30) NOT NULL,
    office VARCHAR(25) NOT NULL, 
    tender VARCHAR(15) NOT NULL,
    customer VARCHAR(20) NOT NULL,
    salesDate DATE DEFAULT CURRENT_DATE(),
    total DECIMAL(16,2) CHECK(total >= 0) NOT NULL,

    PRIMARY KEY(code),
    FOREIGN KEY(office) REFERENCES officeControl.Office(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(tender) REFERENCES humanResourcesControl.Employee(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(customer) REFERENCES customerControl.Customer(NIT) ON UPDATE NO ACTION ON DELETE NO ACTION
);

/*sale*/
CREATE TABLE transactionControl.Purchase(
    code INT8 NOT NULL,
    sale VARCHAR(30) NOT NULL,
    product INT8 NOT NULL,
    cuantity SMALLINT NOT NULL CHECK(cuantity >= 1) DEFAULT 1,
    subtotal DECIMAL(11,2) CHECK(subtotal >= 0) NOT NULL,/*tiene que se más que el producto claro xd*/

    PRIMARY KEY(code),
    FOREIGN KEY(sale) REFERENCES transactionControl.Sale(code) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(product) REFERENCES goodsControl.Product(code) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TYPE state AS ENUM ('pendant', 'read', 'processed', 'done');/*new*/

CREATE TABLE transactionControl.Transfer(
    code INT8 NOT NULL,
    transState state NOT NULL,/*ira cb según la interacción con la interfaz... solo done, tendrá botón para ser marcado...*/
    origin VARCHAR(25) NOT NULL,
    destiny VARCHAR(25) NOT NULL,
    since DATE DEFAULT CURRENT_DATE(),
    until DATE NOT NULL,
    did DATE,/*caundo se transfirió, no nec cuando se Done*//*sin NOT NULL porque eso se seteará en un UPDATE...*/
    reason TEXT NOT NULL,/*si no, entonces BLOB...*/

    PRIMARY KEY(code),
    FOREIGN KEY(origin) REFERENCES officeControl.Office(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(destiny) REFERENCES officeControl.Office(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE transactionControl.ListTransfer(
    transfer INT8 NOT NULL,
    product INT8 NOT NULL,
    quantity INT2 CHECK(quantity >= 1) DEFAULT 1,

    FOREIGN KEY(transfer) REFERENCES transactionControl.Transfer(code) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY(product) REFERENCES goodsControl.Product(code) ON UPDATE NO ACTION ON DELETE NO ACTION
);

\dt transactionControl.*


DROP TABLE productionControl.Sales;
DROP SCHEMA IF EXISTS productionControl;

DROP TABLE storageControl.Product;
DROP SCHEMA IF EXISTS storageControl;

DROP TABLE employeeControl.Employee;
DROP SCHEMA IF EXISTS employeeControl;

DROP DATABASE musicalStore;