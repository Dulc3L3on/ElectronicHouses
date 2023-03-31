/*INSERT INTO Schema.Table VALUES (value, value ... value);*/

/*INDEXATOR*/
    INSERT INTO tool.Indexator VALUES ('office', 'OID', 12536480);
    INSERT INTO tool.Indexator VALUES ('employee', 'EOC', 0000003);
    INSERT INTO tool.Indexator VALUES ('employee', 'EON', 3000003);
    INSERT INTO tool.Indexator VALUES ('employee', 'EOS', 6000003);
    INSERT INTO tool.Indexator VALUES ('employee', 'EOT', 9000003);
    INSERT INTO tool.Indexator VALUES ('employee', 'EOA', 10000000);
    /*Contract no, porque se va a setear el valor de incio en auto-increment con un ALTER (si no pudieras, entonces si addlo xD)*/
    /*Product está en la misma situación que Contract*/
    INSERT INTO tool.Indexator VALUES ('stock', 'ABC', 123456508);
    INSERT INTO tool.Indexator VALUES ('stock', 'ABN', 123456504);
    INSERT INTO tool.Indexator VALUES ('stock', 'ABS', 123456505);
    INSERT INTO tool.Indexator VALUES ('stock', 'ABT', 123456503);
    INSERT INTO tool.Indexator VALUES ('sale', 'SID', 50000000);    
    
    INSERT INTO tool.Indexator VALUES ('transfer', 'TID', 123456503);

/*OFFICE*/
    INSERT INTO officeControl.Office VALUES ('OID-12536477', 'Sucursal Central', '15a av 6-69 zona 4, Quetzaltenango');
    INSERT INTO officeControl.Office VALUES ('OID-12536478', 'Sucursal Norte', '8va calle 8-85 zona 12, Quetzaltenango');
    INSERT INTO officeControl.Office VALUES ('OID-12536479', 'Sucursal Sur', '7a av 7-55 zona 5, Quetzaltenango');
    INSERT INTO officeControl.Office VALUES ('OID-12536480', 'Bodega Central', '15a av 6-695 zona 4, Quetzaltenango');

/*POSITION*/
    INSERT INTO humanResourcesControl.Position VALUES ('sales', 3700);
    INSERT INTO humanResourcesControl.Position VALUES ('inventary', 3200);
    INSERT INTO humanResourcesControl.Position VALUES ('stowage', 3200);/*lo puse aparte porque él si puede modificar*/
    INSERT INTO humanResourcesControl.Position VALUES ('administrator', 7500);

/*EMPLOYEE*/
    /*EOC- central*/
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOC-0000000', '235698741326', 'Anthony Brown', 'pass', '13-03-2001');/*no puse fecha*/
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOC-0000001', '169778354204', 'William Ardley', 'pass1', '18-03-2001');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOC-0000002', '568746216446', 'Terrence Grandchester', 'sales', 'pass2', '14-03-2001');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOC-0000003', '622553789154', 'Neil Leagan', 'inventary', 'pass3', '27-03-2001');
    /*EON- norte*/
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EON-3000000', '632544899979', 'Archivald Cornwell', 'sales', 'pass4', '13-08-2001');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EON-3000001', '563287444100', 'Alistear Cornwell', 'sales', 'pass5', '17-05-2004');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EON-3000002', '899657523301', 'Annie Britter', 'sales', 'pass6', '13-02-2013');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EON-3000003', '579856324633', 'Mery Jane', 'inventary', 'pass7', '13-03-2001');
    /*EOS- sur*/
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOS-6000000', '784576213879', 'Flamie Hamilton', 'sales', 'pass8', '12-11-2012');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOS-6000001', '103654745698', 'Eleanor Baker', 'sales', 'pass9', '13-03-2007');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOS-6000002', '256799566331', 'Patricia Obrian', 'sales', 'pass10', '15-03-2001');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOS-6000003', '489876531650', 'Eliza Leagan', 'inventary', 'pass11', '14-03-2001');
    
    /*bodega*/
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOT-9000000', '565799331557', 'Patty Clint', 'stowage', 'pass12', '13-03-2001');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOT-9000001', '345623687915', 'Susana Marlow', 'stowage', 'pass13', '12-03-2002');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOT-9000002', '589687431321', 'Maria Lott', 'stowage', 'pass14', '16-07-2009');
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOT-9000003', '589786500546', 'Rosaline Manchester', 'stowage', 'pass15', '13-12-2012');

    /*administrador*/
    INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password, since) VALUES ('EOA-10000000', '791230647713', 'Candice White', 'administrator', 'passA', , '13-03-2001');

/*CONTRACT*/
    /*EOC*/
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOC-0000000', 'OID-12536477', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOC-0000001', 'OID-12536477', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOC-0000002', 'OID-12536477', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOC-0000003', 'OID-12536477', 'inventary', '31-12-2024');
    
    /*EON*/
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EON-3000000', 'OID-12536478', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EON-3000001', 'OID-12536478', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EON-3000002', 'OID-12536478', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EON-3000003', 'OID-12536478', 'inventary', '31-12-2024');

    /*EOS*/
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOS-6000000', 'OID-12536479', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOS-6000001', 'OID-12536479', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOS-6000002', 'OID-12536479', 'sales', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOS-6000003', 'OID-12536479', 'inventary', '31-12-2024');

    /*EOB*/
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOT-9000000', 'OID-12536480', 'stowage', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOT-9000001', 'OID-12536480', 'stowage', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOT-9000002', 'OID-12536480', 'stowage', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOT-9000003', 'OID-12536480', 'stowage', '31-12-2024');

    /*ADMIN*//*pertenece a una tienda??*/
    INSERT INTO humanResourcesControl.Contract (employee, office, position, dueDate) VALUES ('EOA-8000003', '', 'administrator', '31-12-2024');

/*CUSTOMER*/
    INSERT INTO customerControl.Customer VALUES ('766740-K', '253696857414', 'Anfaly Monzon', '5a calle 6-80 zona 1, Retalhuleu');
    INSERT INTO customerControl.Customer VALUES ('2427787-8', '563298741365', 'William Leon', '5a calle 6-80 zona 1, Retalhuleu');
    INSERT INTO customerControl.Customer VALUES ('1086564-A', '632598745663', 'Dulce Leon', '6a av 6-69 zona 4, Quetzaltenango');
    INSERT INTO customerControl.Customer VALUES ('2623277-3', '426598753230', 'Emmanuel Lopez', '8a av 7-69 zona 1, San Marcos');        
    INSERT INTO customerControl.Customer VALUES ('6598723-S', '245631658294', 'Federeck Hernandez', 'ciudad');        

/*CLASIFICATION*/
    INSERT INTO goodsControl.Clasification VALUES ('Stove', 'White Line');
    INSERT INTO goodsControl.Clasification VALUES ('Refrigerator', 'White Line');
    INSERT INTO goodsControl.Clasification VALUES ('Microwave', 'White Line');
    INSERT INTO goodsControl.Clasification VALUES ('Washer', 'White Line');    
    INSERT INTO goodsControl.Clasification VALUES ('Dish washer', 'White Line');/*5*/
    INSERT INTO goodsControl.Clasification VALUES ('Dryer', 'White Line');
    INSERT INTO goodsControl.Clasification VALUES ('Oven', 'White Line');    

    INSERT INTO goodsControl.Clasification VALUES ('TV', 'Brown Line');
    INSERT INTO goodsControl.Clasification VALUES ('Stereo', 'Brown Line');
    INSERT INTO goodsControl.Clasification VALUES ('Video game console', 'Brown Line');/*10*/    
    INSERT INTO goodsControl.Clasification VALUES ('Photographic camera', 'Brown Line');
    INSERT INTO goodsControl.Clasification VALUES ('Radio', 'Brown Line');    

    INSERT INTO goodsControl.Clasification VALUES ('Iron', 'PAE');
    INSERT INTO goodsControl.Clasification VALUES ('Vacuum cleaner', 'PAE');
    INSERT INTO goodsControl.Clasification VALUES ('Fryer', 'PAE');/*15*/
    INSERT INTO goodsControl.Clasification VALUES ('Beater', 'PAE');
    INSERT INTO goodsControl.Clasification VALUES ('Blender', 'PAE');
    INSERT INTO goodsControl.Clasification VALUES ('Coffee maker', 'PAE');

    INSERT INTO goodsControl.Clasification VALUES ('Desktop Computer', 'Gray Line');
    INSERT INTO goodsControl.Clasification VALUES ('Laptop', 'Gray Line');/*20*/    
    INSERT INTO goodsControl.Clasification VALUES ('Tablet', 'Gray Line');
    INSERT INTO goodsControl.Clasification VALUES ('Mobile phone', 'Gray Line');/*22*/

/*APPLIANCE*/    
    INSERT INTO goodsControl.Appliance VALUES ('Door French Refrigerator', 'Frigidaire', 2, '');
    INSERT INTO goodsControl.Appliance VALUES ('Standard Depth Side by Side Refrigerator', 'Frigidaire', 2, '');
    INSERT INTO goodsControl.Appliance VALUES ('Free Standing Gas Dryer', 'Frigidaire', 6, 'Black-Deep');
    INSERT INTO goodsControl.Appliance VALUES ('High Efficiency Top Load Washer', 'Frigidaire', 4, '');
    INSERT INTO goodsControl.Appliance VALUES ('Front control Gas Range with Air Fry', 'Frigidaire', 1, '32 inches |Gray');
    INSERT INTO goodsControl.Appliance VALUES ('Single electric Wall Oven with Total Convection', 'Frigidaire', 7, 'Electric |40 inches');
    INSERT INTO goodsControl.Appliance VALUES ('Over-The-Range Microwave', 'Frigidaire', 3, 'Wall |gray');
    INSERT INTO goodsControl.Appliance VALUES ('Lavaplatos LFID2426TF', 'Frigidaire', 5, 'recessed |24 inches');

    INSERT INTO goodsControl.Appliance VALUES ('LG OLED G2 evo Smart TV con ThinQ AI ', 'LG Electronics', 8, '77 inches |OLED');
    INSERT INTO goodsControl.Appliance VALUES ('Refrigerador Side-By-Side InstaView', 'LG Electronics', 2, '27 feet');
    INSERT INTO goodsControl.Appliance VALUES ('Stove LG Studio', 'LG Electronics', 1, '6.3 pies cúbicos |Wi-Fi |ProBake Convection');
    INSERT INTO goodsControl.Appliance VALUES ('LG CordZero A9 Aspiradora de Mano', 'LG Electronics', 14, 'Wireless | Red');
    INSERT INTO goodsControl.Appliance VALUES ('Robot Aspiradora Hombot con Motor Smart Inverter', 'LG Electronics', 14, 'Metalic color');
    INSERT INTO goodsControl.Appliance VALUES ('Torre de sonido LG XBOOM RN7', 'LG Electronics', 9, '|Karaoke Star| DJ App y DJ Pad |Super Bass Boost |Multi Bluetooth');
    INSERT INTO goodsControl.Appliance VALUES ('LG K22', 'LG Electronics', 22, '| UScellular');    

    INSERT INTO goodsControl.Appliance VALUES ('Refrigerator French Door 521 L', 'Haier', 2, 'Stainless');
    INSERT INTO goodsControl.Appliance VALUES ('Refrigerator Bottom Freezer 297 L', 'Haier', 2, 'Stainless |10 feet');
    
    INSERT INTO goodsControl.Appliance VALUES ('Camera Mirrorless', 'Nikon', 11, 'Video 4K, touch, 24 MP, WiFi');

    INSERT INTO goodsControl.Appliance VALUES ('Camera EOSREBEL T7', 'Cannon', 11, 'Detachable lens');
    INSERT INTO goodsControl.Appliance VALUES ('Camera EOS Rebel T100', 'Cannon', 11, 'Premium Kit, 18 MP, APS-C sensor');

    INSERT INTO goodsControl.Appliance VALUES ('Dish-washer', 'Whirlpool', 5, '24 inches |recessed |steel covered');    

    INSERT INTO goodsControl.Appliance VALUES ('Oster GCSTBS5052', 'Oster', 13, 'Steam Iron |Compact |Ceramic');
    INSERT INTO goodsControl.Appliance VALUES ('Oster BLST4655 Blender', 'Oster', 17, 'Chrome | With Ergonomic Knob');
    INSERT INTO goodsControl.Appliance VALUES ('Oster espresso and cappuccino maker', 'Oster', 18, 'Black');
    INSERT INTO goodsControl.Appliance VALUES ('Oster CKSTFAF7601013 Fryer', 'Oster', 15, 'Air Fryer 3.2 Liter');
    INSERT INTO goodsControl.Appliance VALUES ('Oster CKSTAFOV3 Fryer', 'Oster', 15, 'Super Air Fryer 10 Liters');

    INSERT INTO goodsControl.Appliance VALUES ('BLACK+DECKER IRBD100 QUICK AND EASY', 'BLACK+DECKER', 13, 'Steam Iron');
    INSERT INTO goodsControl.Appliance VALUES ('BLACK+DECKER HB2800G', 'BLACK+DECKER', 16, 'Inmersion Blender |3 in 1');
    INSERT INTO goodsControl.Appliance VALUES ('Black+Decker BLBD210GR Durapro', 'BLACK+DECKER', 17, '1.25 litters');
    INSERT INTO goodsControl.Appliance VALUES ('Black+Decker CM0916B Coffee Machine', 'BLACK+DECKER', 18, '12 Cups | Permanent Filter | Black Color');
    
    INSERT INTO goodsControl.Appliance VALUES ('CORE I3 Desktop Computer', 'HP', 19, 'All-in-one desktop computer |Intel core i3 processor |4GB RAM |1TB hard drive');
    INSERT INTO goodsControl.Appliance VALUES ('HP PAVILION X360 14-DY0008LA i5 1135G7', 'HP', 20, '2.4GHZ |8GB |256GB |14 inches |2IN1 |W11H');

    INSERT INTO goodsControl.Appliance VALUES ('Laptop Dell 3501 CORE i3', 'Dell', 20, ', 15.6 inches |4GB RAM |1TB');
    INSERT INTO goodsControl.Appliance VALUES ('Laptop Dell 3502 Celeron', 'Dell', 20, '15.6 inches |4GB RAM |128GB SSD');

    INSERT INTO goodsControl.Appliance VALUES ('ASUS X515EA-BQ868W i3 1115G4', 'ASUS', 2. '3GHZ |4GB |256GB SSD |15.6 inches |W11');
    INSERT INTO goodsControl.Appliance VALUES ('DEMO - ASUS X515EP-BQ222T i5 1135G7', 'ASUS', 2, '2.4G |8GB |512GB SSD |15.6 inches |W10H MX330');
    
    INSERT INTO goodsControl.Appliance VALUES ('CELULAR XIAOMI REDMI A1', 'XIAOMI', 2, '2GB |32GB |6.52 inches |8MP |GREEN US');
    INSERT INTO goodsControl.Appliance VALUES ('CELULAR XIAOMI REDMI 10A', 'XIAOMI', 2, '3GB |64GB |6.53 inches |13MP |SILVER EU');
    INSERT INTO goodsControl.Appliance VALUES ('CELULAR REALME C11 2021 OCTA', 'XIAOMI', 2, '1.6GHZ |4GB |64GB |6.5 inches |8MP |GRAY US');

    INSERT INTO goodsControl.Appliance VALUES ('Nintendo Switch', 'Nintendo', 10, 'Modelo OLED paquete blanco');
    INSERT INTO goodsControl.Appliance VALUES ('Nintendo Switch Lite', 'Nintendo', 10, 'Turquoise | Coral | Yellow');
    INSERT INTO goodsControl.Appliance VALUES ('Nintendo Switch Joy‑Con controls', 'Nintendo', 10, 'Gray |Red and Blue');

/*PRODUCT*/
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Door French Refrigerator', 'Frigidaire', 7500.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Standard Depth Side by Side Refrigerator', 'Frigidaire', 6700.60);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Refrigerator French Door 521 L', 'Haier', 8350.66);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Stove LG Studio', 'LG Electronics', 9563.55);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('BLACK+DECKER IRBD100 QUICK AND EASY', 'BLACK+DECKER', 3453.04);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('CORE I3 Desktop Computer', 'HP', 10236.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('DEMO - ASUS X515EP-BQ222T i5 1135G7', 'ASUS', 13250.47);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('CELULAR XIAOMI REDMI A1', 'XIAOMI', 6580.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Over-The-Range Microwave', 'Frigidaire', 3680.35);

    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Nintendo Switch', 'Nintendo', 3453.04);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Laptop Dell 3502 Celeron', 'Dell', 10236.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Dish-washer', 'Whirlpool', 13250.47);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('CELULAR XIAOMI REDMI A1', 'XIAOMI', 6580.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Oster BLST4655 Blender', 'Oster', 3680.35);

    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('HP PAVILION X360 14-DY0008LA i5 1135G7', 'HP', 3453.04);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Single electric Wall Oven with Total Convection', 'Frigidaire', 10236.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Laptop Dell 3501 CORE i3', 'Dell', 13250.47);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('LG CordZero A9 Aspiradora de Mano', 'LG Electronics', 6580.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Camera EOS Rebel T100', 'Cannon', 3680.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Oster CKSTAFOV3 Fryer', 'Oster', 3680.35);

    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('LG K22', 'LG Electronics', 13250.47);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Robot Aspiradora Hombot con Motor Smart Inverter', 'LG Electronics', 6580.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('Black+Decker BLBD210GR Durapro', 'BLACK+DECKER', 3680.35);
    INSERT INTO goodsControl.Product (name, theBrand, price) VALUES ('ASUS X515EA-BQ868W i3 1115G4', 'ASUS', 3680.35);

/*STOCK*/
    /*Central*/
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456500', 100000000000, 3, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456501', 100000000012, 2, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456502', 100000000011, 4, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456503', 100000000021, 7, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456504', 100000000019, 3, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456505', 100000000010, 3, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456506', 100000000003, 2, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456507', 100000000018, 2, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456508', 100000000022, 4, 'OID-12536477');

    /*Norte*/
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456500', 100000000017, 9, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456501', 100000000014, 7, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456502', 100000000006, 4, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456503', 100000000001, 2, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456504', 100000000003, 3, 'OID-12536478');

    /*Sur*/
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456500', 100000000016, 3, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456501', 100000000005, 2, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456502', 100000000002, 4, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456503', 100000000022, 3, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456504', 100000000012, 1, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456505', 100000000011, 2, 'OID-12536479');

    /*Bodega*/
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456500', 100000000015, 4, 'OID-12536480');
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456501', 100000000008, 9, 'OID-12536480');
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456502', 100000000001, 15, 'OID-12536480');
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456503', 100000000017, 4, 'OID-12536480');

