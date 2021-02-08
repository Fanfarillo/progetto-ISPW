delimiter !

CREATE TRIGGER `progettoispwfinaledatabase`.`trigger_update_dish` AFTER UPDATE ON `piatto` FOR EACH ROW
BEGIN	
	declare oldprezzo float;
    declare newprezzo float;
    declare numdishes int;
    declare oldtotale float;
    declare old_all_dishes_price float;
    declare new_all_dishes_price float;
    
    set oldprezzo = old.prezzo;
    set newprezzo = new.prezzo;
    select count(*) into numdishes from piatto where NomeRistorante = old.NomeRistorante;
    select totale into oldtotale from menu where NomeRistorante = old.NomeRistorante;
    set old_all_dishes_price = oldtotale*numdishes/3;
    set new_all_dishes_price = old_all_dishes_price - oldprezzo + newprezzo;
    
    update menu set totale = 3*new_all_dishes_price/numdishes where NomeRistorante = old.NomeRistorante;
END!

delimiter ;

delimiter !

CREATE TRIGGER `progettoispwfinaledatabase`.`trigger_add_dish` AFTER UPDATE ON `piatto` FOR EACH ROW
BEGIN
	declare prezzo float;
    declare old_num_dishes int;
    declare new_num_dishes int;
    declare oldtotale float;
    declare old_all_dishes_price float;
    declare new_all_dishes_price float;
    
    set prezzo = new.prezzo;
    select count(*) into old_num_dishes from piatto where NomeRistorante = old.NomeRistornate;
    set new_num_dishes = old_num_dishes+1;
    select totale into oldtotale from menu where NomeRistorante = old.NomeRistorante;
    set old_all_dishes_price = oldtotale*old_num_dishes/3;
    set new_all_dishes_price = old_all_dishes_price + prezzo;
    
    update menu set totale = 3*new_all_dishes_price/new_num_dishes where NomeRistorante = old.NomeRistorante;
END!

delimiter ;
delimiter !

CREATE TRIGGER `progettoispwfinaledatabase`.`trigger_delete_dish` AFTER UPDATE ON `piatto` FOR EACH ROW
BEGIN
	declare prezzo float;
    declare old_num_dishes int;
    declare new_num_dishes int;
    declare oldtotale float;
    declare old_all_dishes_price float;
    declare new_all_dishes_price float;
    
    set prezzo = old.prezzo;
    select count(*) into old_num_dishes from piatto where NomeRistorante = old.NomeRistorante;
    set new_num_dishes = old_num_dishes-1;
    select totale into oldtotale from menu where NomeRistorante = old.NomeRistorante;
    set old_all_dishes_price = oldtotale*old_num_dishes/3;
    set new_all_dishes_price = old_all_dishes_price - prezzo;
    
    if new_num_dishes > 0 then
		update menu set totale = 3*new_all_dishes_price/new_num_dishes where NomeRistorante = old.NomeRistorante;
	else
		update menu set totale = 0 where NomeRistorante = old.NomeRistorante;
	end if;
END!

delimiter ;