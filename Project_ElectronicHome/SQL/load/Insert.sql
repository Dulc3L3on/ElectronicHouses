/*INSERT INTO Schema.Table VALUES (value, value ... value);*/

/*OFFICE*/
    INSERT INTO officeControl.Office VALUES ('OID-12536477', 'Sucursal Central', '15a av 6-69 zona 4, Quetzaltenango');
    INSERT INTO officeControl.Office VALUES ('OID-12536478', 'Sucursal Norte', '8va calle 8-85 zona 12, Quetzaltenango');
    INSERT INTO officeControl.Office VALUES ('OID-12536479', 'Sucursal Sur', '7a av 7-55 zona 5, Quetzaltenango');
    INSERT INTO officeControl.Office VALUES ('OID-12536480', 'Bodega Central', '15a av 6-695 zona 4, Quetzaltenango');

/*POSITION*/
    INSERT INTO humanResourcesControl.Employee VALUES ('sales', 3500);
    INSERT INTO humanResourcesControl.Employee VALUES ('inventary', 3200);
    INSERT INTO humanResourcesControl.Employee VALUES ('stowage', 3200);/*lo puse aparte porque él si puede modificar*/
    INSERT INTO humanResourcesControl.Employee VALUES ('administrator', 7500);

/*EMPLOYEE*/
    /*EOC- central*/
    INSERT INTO humanResourcesControl.Employee VALUES ('EOC-2000000', '235698741326', 'Anthony Brown', 'sales', '13-03-2001', 'pass');/*no puse fecha*/
    INSERT INTO humanResourcesControl.Employee VALUES ('EOC-2000001', '169778354204', 'William Ardley', 'sales', '18-03-2001', 'pass1');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOC-2000002', '568746216446', 'Terrence Grandchester', 'sales', '14-03-2001', 'pass2');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOC-2000003', '622553789154', 'Neil Leagan', 'inventary', '27-03-2001', 'pass3');
    /*EON- norte*/
    INSERT INTO humanResourcesControl.Employee VALUES ('EON-4000000', '632544899979', 'Archivald Cornwell', 'sales', '13-08-2001', 'pass4');
    INSERT INTO humanResourcesControl.Employee VALUES ('EON-4000001', '563287444100', 'Alistear Cornwell', 'sales', '17-05-2004', 'pass5');
    INSERT INTO humanResourcesControl.Employee VALUES ('EON-4000002', '899657523301', 'Annie Britter', 'sales', '13-02-2013', 'pass6');
    INSERT INTO humanResourcesControl.Employee VALUES ('EON-4000003', '579856324633', 'Mery Jane', 'inventary', '13-03-2001', 'pass7');
    /*EOS- sur*/
    INSERT INTO humanResourcesControl.Employee VALUES ('EOS-6000000', '784576213879', 'Flamie Hamilton', 'sales', '12-11-2012', 'pass8');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOS-6000001', '103654745698', 'Eleanor Baker', 'sales', '13-03-2007', 'pass9');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOS-6000002', '256799566331', 'Patricia Obrian', 'sales', '15-03-2001', 'pass10');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOS-6000003', '489876531650', 'Eliza Leagan', 'inventary', '14-03-2001', 'pass11');
    
    /*bodega*/
    INSERT INTO humanResourcesControl.Employee VALUES ('EOT-8000000', '565799331557', 'Patty Clint', 'stowage', '13-03-2001', 'pass12');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOT-8000001', '345623687915', 'Susana Marlow', 'stowage', '12-03-2002', 'pass13');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOT-8000002', '589687431321', 'Maria Lott', 'stowage', '16-07-2009', 'pass14');
    INSERT INTO humanResourcesControl.Employee VALUES ('EOT-8000003', '589786500546', 'Rosaline Manchester', 'stowage', '13-12-2012', 'pass15');

    /*administrador*/
    INSERT INTO humanResourcesControl.Employee VALUES ('EOA-10000000', '791230647713', 'Candice White', 'administrator');

/*CONTRACT*/
    /*EOC*/
    INSERT INTO humanResourcesControl.Contract VALUES (562355, 'EOC-2000000', 'OID-12536477', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562356, 'EOC-2000001', 'OID-12536477', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562357, 'EOC-2000002', 'OID-12536477', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562358, 'EOC-2000003', 'OID-12536477', '31-12-2024');
    
    /*EON*/
    INSERT INTO humanResourcesControl.Contract VALUES (562359, 'EON-4000000', 'OID-12536478', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562360, 'EON-4000001', 'OID-12536478', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562361, 'EON-4000002', 'OID-12536478', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562362, 'EON-4000003', 'OID-12536478', '31-12-2024');

    /*EOS*/
    INSERT INTO humanResourcesControl.Contract VALUES (562363, 'EOS-6000000', 'OID-12536479', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562364, 'EOS-6000001', 'OID-12536479', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562365, 'EOS-6000002', 'OID-12536479', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562366, 'EOS-6000003', 'OID-12536479', '31-12-2024');

    /*EOB*/
    INSERT INTO humanResourcesControl.Contract VALUES (562363, 'EOT-8000000', 'OID-12536480', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562364, 'EOT-8000001', 'OID-12536480', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562365, 'EOT-8000002', 'OID-12536480', '31-12-2024');
    INSERT INTO humanResourcesControl.Contract VALUES (562366, 'EOT-8000003', 'OID-12536480', '31-12-2024');

    /*ADMIN*//*pertenece a una tienda??*/
    INSERT INTO humanResourcesControl.Contract VALUES (562366, 'EO-8000003', '', '31-12-2024');

/*CUSTOMER*/
    INSERT INTO humanResourcesControl.Contract VALUES ('766740-K', 'Anfaly Monzon', '253696857414', '5a calle 6-80 zona 1, Retalhuleu');
    INSERT INTO humanResourcesControl.Contract VALUES ('2427787-8', 'William Leon', '563298741365', '5a calle 6-80 zona 1, Retalhuleu');
    INSERT INTO humanResourcesControl.Contract VALUES ('1086564-A', 'Dulce Leon', '632598745663', '6a av 6-69 zona 4, Quetzaltenango');
    INSERT INTO humanResourcesControl.Contract VALUES ('2623277-3', 'Emmanuel Lopez', '426598753230', '8a av 7-69 zona 1, San Marcos');        
    INSERT INTO humanResourcesControl.Contract VALUES ('6598723-S', 'Federeck Hernandez', '245631658294', 'ciudad');        

/*CLASIFICATION*/
    INSERT INTO humanResourcesControl.Contract VALUES ('Stove', 'White Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Refrigerator', 'White Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Microwave', 'White Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Washer', 'White Line');    
    INSERT INTO humanResourcesControl.Contract VALUES ('Dish washer', 'White Line');/*5*/
    INSERT INTO humanResourcesControl.Contract VALUES ('Dryer', 'White Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Oven', 'White Line');    

    INSERT INTO humanResourcesControl.Contract VALUES ('TV', 'Brown Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Stereo', 'Brown Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Video game console', 'Brown Line');/*10*/    
    INSERT INTO humanResourcesControl.Contract VALUES ('Photographic camera', 'Brown Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Radio', 'Brown Line');    

    INSERT INTO humanResourcesControl.Contract VALUES ('Iron', 'PAE');
    INSERT INTO humanResourcesControl.Contract VALUES ('Vacuum cleaner', 'PAE');
    INSERT INTO humanResourcesControl.Contract VALUES ('Fryer', 'PAE');/*15*/
    INSERT INTO humanResourcesControl.Contract VALUES ('Beater', 'PAE');
    INSERT INTO humanResourcesControl.Contract VALUES ('Blender', 'PAE');
    INSERT INTO humanResourcesControl.Contract VALUES ('Coffee maker', 'PAE');

    INSERT INTO humanResourcesControl.Contract VALUES ('Desktop Computer', 'Gray Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Laptop', 'Gray Line');/*20*/    
    INSERT INTO humanResourcesControl.Contract VALUES ('Tablet', 'Gray Line');
    INSERT INTO humanResourcesControl.Contract VALUES ('Mobile phone', 'Gray Line');/*22*/

/*APPLIANCE*/    
    INSERT INTO humanResourcesControl.Contract VALUES ('Door French Refrigerator', 'Frigidaire', 2, '');
    INSERT INTO humanResourcesControl.Contract VALUES ('Standard Depth Side by Side Refrigerator', 'Frigidaire', 2, '');
    INSERT INTO humanResourcesControl.Contract VALUES ('Free Standing Gas Dryer', 'Frigidaire', 6, 'Black-Deep');
    INSERT INTO humanResourcesControl.Contract VALUES ('High Efficiency Top Load Washer', 'Frigidaire', 4, '');
    INSERT INTO humanResourcesControl.Contract VALUES ('Front control Gas Range with Air Fry', 'Frigidaire', 1, '32 inches |Gray');
    INSERT INTO humanResourcesControl.Contract VALUES ('Single electric Wall Oven with Total Convection', 'Frigidaire', 7, 'Electric |40 inches');
    INSERT INTO humanResourcesControl.Contract VALUES ('Over-The-Range Microwave', 'Frigidaire', 3, 'Wall |gray');
    INSERT INTO humanResourcesControl.Contract VALUES ('Lavaplatos LFID2426TF', 'Frigidaire', 5, 'recessed |24 inches');

    INSERT INTO humanResourcesControl.Contract VALUES ('LG OLED G2 evo Smart TV con ThinQ AI ', 'LG Electronics', 8, '77 inches |OLED');
    INSERT INTO humanResourcesControl.Contract VALUES ('Refrigerador Side-By-Side InstaView', 'LG Electronics', 2, '27 feet');
    INSERT INTO humanResourcesControl.Contract VALUES ('Stove LG Studio', 'LG Electronics', 1, '6.3 pies cúbicos |Wi-Fi |ProBake Convection');
    INSERT INTO humanResourcesControl.Contract VALUES ('LG CordZero A9 Aspiradora de Mano', 'LG Electronics', 14, 'Wireless | Red');
    INSERT INTO humanResourcesControl.Contract VALUES ('Robot Aspiradora Hombot con Motor Smart Inverter', 'LG Electronics', 14, 'Metalic color');
    INSERT INTO humanResourcesControl.Contract VALUES ('Torre de sonido LG XBOOM RN7', 'LG Electronics', 9, '|Karaoke Star| DJ App y DJ Pad |Super Bass Boost |Multi Bluetooth');
    INSERT INTO humanResourcesControl.Contract VALUES ('LG K22', 'LG Electronics', 22, '| UScellular');    

    INSERT INTO humanResourcesControl.Contract VALUES ('Refrigerator French Door 521 L', 'Haier', 2, 'Stainless');
    INSERT INTO humanResourcesControl.Contract VALUES ('Refrigerator Bottom Freezer 297 L', 'Haier', 2, 'Stainless |10 feet');
    
    INSERT INTO humanResourcesControl.Contract VALUES ('Camera Mirrorless', 'Nikon', 11, 'Video 4K, touch, 24 MP, WiFi');

    INSERT INTO humanResourcesControl.Contract VALUES ('Camera EOSREBEL T7', 'Cannon', 11, 'Detachable lens');
    INSERT INTO humanResourcesControl.Contract VALUES ('Camera EOS Rebel T100', 'Cannon', 11, 'Premium Kit, 18 MP, APS-C sensor');

    INSERT INTO humanResourcesControl.Contract VALUES ('Dish-washer', 'Whirlpool', 5, '24 inches |recessed |steel covered');    

    INSERT INTO humanResourcesControl.Contract VALUES ('Oster GCSTBS5052', 'Oster', 13, 'Steam Iron |Compact |Ceramic');
    INSERT INTO humanResourcesControl.Contract VALUES ('Oster BLST4655 Blender', 'Oster', 17, 'Chrome | With Ergonomic Knob');
    INSERT INTO humanResourcesControl.Contract VALUES ('Oster espresso and cappuccino maker', 'Oster', 18, 'Black');
    INSERT INTO humanResourcesControl.Contract VALUES ('Oster CKSTFAF7601013 Fryer', 'Oster', 15, 'Air Fryer 3.2 Liter');
    INSERT INTO humanResourcesControl.Contract VALUES ('Oster CKSTAFOV3 Fryer', 'Oster', 15, 'Super Air Fryer 10 Liters');

    INSERT INTO humanResourcesControl.Contract VALUES ('BLACK+DECKER IRBD100 QUICK AND EASY', 'BLACK+DECKER', 13, 'Steam Iron');
    INSERT INTO humanResourcesControl.Contract VALUES ('BLACK+DECKER HB2800G', 'BLACK+DECKER', 16, 'Inmersion Blender |3 in 1');
    INSERT INTO humanResourcesControl.Contract VALUES ('Black+Decker BLBD210GR Durapro', 'BLACK+DECKER', 17, '1.25 litters');
    INSERT INTO humanResourcesControl.Contract VALUES ('Black+Decker CM0916B Coffee Machine', 'BLACK+DECKER', 18, '12 Cups | Permanent Filter | Black Color');
    
    INSERT INTO humanResourcesControl.Contract VALUES ('CORE I3 Desktop Computer', 'HP', 19, 'All-in-one desktop computer |Intel core i3 processor |4GB RAM |1TB hard drive');
    INSERT INTO humanResourcesControl.Contract VALUES ('HP PAVILION X360 14-DY0008LA i5 1135G7', 'HP', 20, '2.4GHZ |8GB |256GB |14 inches |2IN1 |W11H');

    INSERT INTO humanResourcesControl.Contract VALUES ('Laptop Dell 3501 CORE i3', 'Dell', 20, ', 15.6 inches |4GB RAM |1TB');
    INSERT INTO humanResourcesControl.Contract VALUES ('Laptop Dell 3502 Celeron', 'Dell', 20, '15.6 inches |4GB RAM |128GB SSD');

    INSERT INTO humanResourcesControl.Contract VALUES ('ASUS X515EA-BQ868W i3 1115G4', 'ASUS', 2. '3GHZ |4GB |256GB SSD |15.6 inches |W11');
    INSERT INTO humanResourcesControl.Contract VALUES ('DEMO - ASUS X515EP-BQ222T i5 1135G7', 'ASUS', 2, '2.4G |8GB |512GB SSD |15.6 inches |W10H MX330');
    
    INSERT INTO humanResourcesControl.Contract VALUES ('CELULAR XIAOMI REDMI A1', 'XIAOMI', 2, '2GB |32GB |6.52 inches |8MP |GREEN US');
    INSERT INTO humanResourcesControl.Contract VALUES ('CELULAR XIAOMI REDMI 10A', 'XIAOMI', 2, '3GB |64GB |6.53 inches |13MP |SILVER EU');
    INSERT INTO humanResourcesControl.Contract VALUES ('CELULAR REALME C11 2021 OCTA', 'XIAOMI', 2, '1.6GHZ |4GB |64GB |6.5 inches |8MP |GRAY US');

    INSERT INTO humanResourcesControl.Contract VALUES ('Nintendo Switch', 'Nintendo', 10, 'Modelo OLED paquete blanco');
    INSERT INTO humanResourcesControl.Contract VALUES ('Nintendo Switch Lite', 'Nintendo', 10, 'Turquoise | Coral | Yellow');
    INSERT INTO humanResourcesControl.Contract VALUES ('Nintendo Switch Joy‑Con controls', 'Nintendo', 10, 'Gray |Red and Blue');

/*STOCK*/
    /*Central*/
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456500', 3, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456501', 2, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456502', 4, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456503', 7, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456504', 3, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456505', 3, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456506', 2, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456507', 2, 'OID-12536477');
    INSERT INTO goodsControl.Stock VALUES ('ABC-123456508', 4, 'OID-12536477');

    /*Norte*/
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456500', 9, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456501', 7, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456502', 4, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456503', 2, 'OID-12536478');
    INSERT INTO goodsControl.Stock VALUES ('ABN-123456504', 3, 'OID-12536478');

    /*Sur*/
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456500', 3, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456501', 2, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456502', 4, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456503', 3, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456504', 1, 'OID-12536479');
    INSERT INTO goodsControl.Stock VALUES ('ABS-123456505', 2, 'OID-12536479');

    /*Bodega*/
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456500', 4, 'OID-12536480');
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456501', 9, 'OID-12536480');
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456502', 15, 'OID-12536480');
    INSERT INTO goodsControl.Stock VALUES ('ABT-123456503', 4, 'OID-12536480');

/*PRODUCT*/
    INSERT INTO goodsControl.Product VALUES (656423319787, 'Door French Refrigerator', 'Frigidaire', 'ABC-123456500', 7500.35);
    INSERT INTO goodsControl.Product VALUES (032164548975, 'Standard Depth Side by Side Refrigerator', 'Frigidaire', 'ABC-123456500', 6700.60);
    INSERT INTO goodsControl.Product VALUES (951357864230, 'Refrigerator French Door 521 L', 'Haier', 'ABC-123456500', 8350.66);
    INSERT INTO goodsControl.Product VALUES (032654897980, 'Stove LG Studio', 'LG Electronics', 'ABC-123456500', 9563.55);
    INSERT INTO goodsControl.Product VALUES (798885645310, 'BLACK+DECKER IRBD100 QUICK AND EASY', 'BLACK+DECKER', 'ABC-123456500', 3453.04);
    INSERT INTO goodsControl.Product VALUES (856321497850, 'CORE I3 Desktop Computer', 'HP', 'ABC-123456500', 10236.35);
    INSERT INTO goodsControl.Product VALUES (563216047990, 'DEMO - ASUS X515EP-BQ222T i5 1135G7', 'ASUS', 'ABC-123456500', 13250.47);
    INSERT INTO goodsControl.Product VALUES (236546549870, 'CELULAR XIAOMI REDMI A1', 'XIAOMI', 'ABC-123456500', 6580.35);
    INSERT INTO goodsControl.Product VALUES (987654325663, 'Over-The-Range Microwave', 'Frigidaire', 'ABC-123456500', 3680.35);

    INSERT INTO goodsControl.Product VALUES (798885645310, 'Nintendo Switch', 'Nintendo', 'ABC-123456500', 3453.04);
    INSERT INTO goodsControl.Product VALUES (856321497850, 'Laptop Dell 3502 Celeron', 'Dell', 'ABC-123456500', 10236.35);
    INSERT INTO goodsControl.Product VALUES (563216047990, 'Dish-washer', 'Whirlpool', 'ABC-123456500', 13250.47);
    INSERT INTO goodsControl.Product VALUES (236546549870, 'CELULAR XIAOMI REDMI A1', 'XIAOMI', 'ABC-123456500', 6580.35);
    INSERT INTO goodsControl.Product VALUES (987654325663, 'Oster BLST4655 Blender', 'Oster', 'ABC-123456500', 3680.35);

    INSERT INTO goodsControl.Product VALUES (798885645310, 'HP PAVILION X360 14-DY0008LA i5 1135G7', 'HP', 'ABC-123456500', 3453.04);
    INSERT INTO goodsControl.Product VALUES (856321497850, 'Single electric Wall Oven with Total Convection', 'Frigidaire', 'ABC-123456500', 10236.35);
    INSERT INTO goodsControl.Product VALUES (563216047990, 'Laptop Dell 3501 CORE i3', 'Dell', 'ABC-123456500', 13250.47);
    INSERT INTO goodsControl.Product VALUES (236546549870, 'LG CordZero A9 Aspiradora de Mano', 'LG Electronics', 'ABC-123456500', 6580.35);
    INSERT INTO goodsControl.Product VALUES (987654325663, 'Camera EOS Rebel T100', 'Cannon', 'ABC-123456500', 3680.35);
    INSERT INTO goodsControl.Product VALUES (987654325663, 'Oster CKSTAFOV3 Fryer', 'Oster', 'ABC-123456500', 3680.35);

    INSERT INTO goodsControl.Product VALUES (563216047990, 'LG K22', 'LG Electronics', 13250.47);
    INSERT INTO goodsControl.Product VALUES (236546549870, 'Robot Aspiradora Hombot con Motor Smart Inverter', 'LG Electronics', 'ABC-123456500', 6580.35);
    INSERT INTO goodsControl.Product VALUES (987654325663, 'Black+Decker BLBD210GR Durapro', 'BLACK+DECKER', 'ABC-123456500', 3680.35);
    INSERT INTO goodsControl.Product VALUES (987654325663, 'ASUS X515EA-BQ868W i3 1115G4', 'ASUS', 'ABC-123456500', 3680.35);