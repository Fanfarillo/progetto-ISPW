delimiter !

CREATE DEFINER=`root`@`localhost` PROCEDURE `aggiungi_piatto4`(IN nomeRistorante varchar(45), IN nomePiatto varchar(45), IN contenuto varchar(10000), IN prezzo double, IN vegano boolean, IN celiaco boolean)
BEGIN
-- DICHIARAZIONE DELLE VARIABILI DA UTILIZZARE
		declare u varchar(45);
        DECLARE cardinalita int default -1;
		declare done int default false;
        declare cur cursor for select distinct username from turista as t, preferiti as p where t.Username = p.UsernameTurista and p.NomeRistorante = nomeRistorante;
        declare continue handler for not found set done = true;        
        
        -- INSERIMENTO DEL NUOVO PIATTO IN UN RISTORANTE
        insert into piatto(NomeRistorante,NomePiatto,Contenuto,Prezzo,Vegano,Celiaco) values(nomeRistorante,nomePiatto,contenuto,prezzo,vegano,celiaco);
        
        -- APRO IL CURSORE ED DESEGUO LA SELECT AD ESSO ASSOCIATA
        open cur;        
		
        -- CICLO SUI RISULTATI
        read_loop: loop
			fetch cur into u;
            if done then
				leave read_loop;
			end if;
				-- rispetto il vincolo di integrità 
				 select count(*) into cardinalita from notificamenuaggiornato as n where n.UsernameTurista = u and n.NomePiatto = nomePiatto and n.NomeRistorante = nomeRistorante;
                -- se non ci sta inserisco la notifica altrimenti non faccio nulla così da rispettare il vincolo
                 if cardinalita = 0 then
					 insert into notificamenuaggiornato(UsernameTurista, NomeRistorante, TIpoModifica,NomePiatto,Vista) values(u,nomeRistorante,0,nomePiatto,false);
				 end if;
            
		end loop;
        close cur;   
END!

delimiter ;