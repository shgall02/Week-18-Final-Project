-- userData
insert into userdata(firstName, lastName, Location) values ('Shawntel', 'Gallegos', 'New Mexico');
insert into userdata(firstName, lastName, Location) values ('John', 'Stamos', 'Los Angeles');
insert into userdata(firstName, lastName, Location) values ('Winona', 'Ryder', 'Los Angeles');
insert into userdata(firstName, lastName, Location) values ('Dave', 'Chapelle', 'Ohio');
insert into userdata(firstName, lastName, Location) values ('Tom', 'Selleck', 'Detroit');

-- Computers
insert into computers(userId, serviceTag, make, model, expiration) values (1, 'D56CML3', 'Dell', 'Latitude 3310', '2025-05-26');
insert into computers(userId, serviceTag, make, model, expiration) values (2, '856CML3', 'Dell', 'Latitude 3310', '2025-05-26');
insert into computers(userId, serviceTag, make, model, expiration) values (3, '256CML3', 'Dell', 'Latitude 3310', '2025-05-26');
insert into computers(userId, serviceTag, make, model, expiration) values (4, 'F56CML3', 'Dell', 'Latitude 3310', '2025-05-26');
insert into computers(userId, serviceTag, make, model, expiration) values (5, 'BFGJML3', 'Dell', 'Latitude 3310', '2025-05-26');

-- Peripherals
insert into peripherals(userId, Device, Make, Model) values (1, 'Printer', 'Konica Minolta', 'Bizhub 4020i');
insert into peripherals(userId, Device, Make, Model) values (2, 'Kyboard', 'Logitech', 'K350 Wave');
insert into peripherals(userId, Device, Make, Model) values (2, 'mouse', 'Logitech', 'M705 Marathon');
insert into peripherals(userId, Device, Make, Model) values (3, 'Monitor', 'Dell', 'UltraSharp - U2422H');
insert into peripherals(userId, Device, Make, Model) values (3, 'Docking Station', 'Dell', 'WD19');

-- Request Type
insert into RequestType(typeName) values ('Computer');
insert into RequestType(typeName) values ('Peripherals');

-- Requests
insert into requests(userId, typeId, quantity, shipDate, receiveDate) values (1, 1, 1, 2, '2022-9-12', '2022-9-13');
insert into requests(userId, typeId, quantity, shipDate, receiveDate) values (2, 2, 2, 3, '2022-9-12', '2022-9-13');
insert into requests(userId, typeId, quantity, shipDate, receiveDate) values (3, 3, 3, 4, '2022-9-12', '2022-9-13');
insert into requests(userId, typeId, quantity, shipDate, receiveDate) values (4, 4, 4, 2, '2022-9-12', '2022-9-13');
insert into requests(userId, typeId, quantity, shipDate, receiveDate) values (5, 5, 5, 1, '2022-9-12', '2022-9-13');


