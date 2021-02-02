CREATE DEFINER=`root`@`localhost` PROCEDURE `aggiorna_piatto4`(IN nomeRistorante varchar(45), IN nomePiatto varchar(45), IN contenuto varchar(10000), IN prezzo double, IN vegano boolean, IN celiaco boolean)
BEGIN
	-- DICHIARAZIONE DELLE VARIABILI DA UTILIZZARE
		declare u varchar(45);
        DECLARE cardinalita int default -1;
		declare done int default false;
        declare cur cursor for select distinct username from turista as t, preferiti as p where t.Username = p.UsernameTurista and p.NomeRistorante = nomeRistorante;
        declare continue handler for not found set done = true;        
        
        select count(*) into cardinalita from piatto as p where p.NomePiatto = nomePiatto and p.NomeRistorante = nomeRistorante;
        if cardinalita = 0 then
			signal sqlstate '45000';
		end if;
        
        -- AGGIORNAMENTO DEL PIATTO RICHIESTO IN UN RISTORANTE
        update piatto as p set p.Contenuto = contenuto, p.Prezzo = prezzo, p.Vegano = vegano, p.Celiaco = celiaco where p.NomePiatto = nomePiatto and p.NomeRistorante = nomeRistorante;
        -- signal sqlstate '45000';
        -- APRO IL CURSORE ED DESEGUO LA SELECT AD ESSO ASSOCIATA: ottengo gli utenti che hanno quel ristorante tra i preferiti
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
					  insert into notificamenuaggiornato(UsernameTurista, NomeRistorante, TIpoModifica,NomePiatto,Vista) values(u,nomeRistorante,1,nomePiatto,false);
				  else
					  delete from notificamenuaggiornato as n where  n.UsernameTurista = u and n.NomePiatto = nomePiatto and n.NomeRistorante = nomeRistorante;
                      insert into notificamenuaggiornato(UsernameTurista, NomeRistorante, TIpoModifica,NomePiatto,Vista) values(u,nomeRistorante,1,nomePiatto,false);
				  end if;
           
		 end loop;
        close cur;  
END