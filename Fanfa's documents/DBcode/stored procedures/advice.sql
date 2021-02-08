delimiter !

CREATE DEFINER=`root`@`localhost` PROCEDURE `advice`(in username varchar(45))
BEGIN
	
  
   
   select *
   from piattotipico 
   where NomePiatto <> all (select NomePiatto from piatto join ristorante on piatto.NomeRistorante = ristorante.Nome where ristorante.UsernameProprietario = username);
    
END!

delimiter ;