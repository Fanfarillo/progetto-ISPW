delimiter !

CREATE TRIGGER `progettoispwfinaledatabase`.`trigger_update_dish` AFTER UPDATE ON `piatto` FOR EACH ROW
BEGIN	
	declare oldprezzo float;
    declare newprezzo float;
    declare numdishes int;
    declare oldtotale float;
    declare old_all_dishes_price float;
    declare new_all_dishes_price float;
    
    set oldprezzo = old.Prezzo;
    set newprezzo = new.Prezzo;
    select count(*) into numdishes from piatto where NomeRistorante = old.NomeRistorante;
    select totale into oldtotale from menu where NomeRistorante = old.NomeRistorante;
    set old_all_dishes_price = oldtotale*numdishes/3;
    set new_all_dishes_price = old_all_dishes_price - oldprezzo + newprezzo;
    
    update menu set totale = 3*new_all_dishes_price/numdishes where NomeRistorante = new.NomeRistorante;
END!

delimiter ;

delimiter !

CREATE TRIGGER `progettoispwfinaledatabase`.`trigger_add_dish` AFTER INSERT ON `piatto` FOR EACH ROW
BEGIN
	declare prezzo float;
    declare old_num_dishes int;
    declare new_num_dishes int;
    declare oldtotale float;
    declare old_all_dishes_price float;
    declare new_all_dishes_price float;
    
    set prezzo = new.Prezzo;
    select count(*) into new_num_dishes from piatto where NomeRistorante = new.NomeRistorante;
    set old_num_dishes = new_num_dishes-1;
    
    if old_num_dishes > 0 then
		select totale into oldtotale from menu where NomeRistorante = new.NomeRistorante;
        set old_all_dishes_price = oldtotale*old_num_dishes/3;
	else
		set oldtotale = 0;
        set old_all_dishes_price = 0;
	end if;

    set new_all_dishes_price = old_all_dishes_price + prezzo;
    
    update menu set totale = 3*new_all_dishes_price/new_num_dishes where NomeRistorante = new.NomeRistorante;
END!

delimiter ;
delimiter !

CREATE TRIGGER `progettoispwfinaledatabase`.`trigger_delete_dish` AFTER DELETE ON `piatto` FOR EACH ROW
BEGIN
	declare prezzo float;
    declare old_num_dishes int;
    declare new_num_dishes int;
    declare oldtotale float;
    declare old_all_dishes_price float;
    declare new_all_dishes_price float;
    
    set prezzo = old.Prezzo;
    select count(*) into new_num_dishes from piatto where NomeRistorante = old.NomeRistorante;
    set old_num_dishes = new_num_dishes+1;
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