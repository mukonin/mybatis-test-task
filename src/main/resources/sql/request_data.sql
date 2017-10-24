CREATE PROCEDURE init_requests()
	BEGIN
		DECLARE session_id INT(10);
		DECLARE cursor1 CURSOR FOR SELECT id FROM sessions;
		OPEN cursor1;
		read_loop: LOOP
			FETCH cursor1
			INTO session_id;
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://www.example.com/', 'arm=belief&bike=art', session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'https://bed.example.org/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'http://www.example.com/believe.php', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://www.example.edu/airplane', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'https://example.com/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'http://authority.example.net/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://www.example.com/bead.php', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'https://www.example.org/aftermath/aunt.html', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'https://beef.example.edu/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://example.com/actor', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'http://blow.example.org/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'https://appliance.example.com/', 'bike=bike', session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://www.example.com/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'http://www.example.net/', 'aftermath=advice', session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'https://www.example.com/', 'anger=achiever&boot=back', session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://www.example.com/behavior.html', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'http://example.com/bikes/bath', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'https://www.example.net/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'https://www.example.com/bone.html', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'https://www.example.org/animal.html', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'http://bird.example.com/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'https://example.com/bikes/addition#approval', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'https://example.com/army', 'arithmetic=airport&aunt=board', session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'http://www.example.com/arch.htm', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'http://www.example.org/battle', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'http://example.com/art.html', 'balance=blade&border=arithmetic', session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'https://www.example.com/brick/book', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('GET', 'https://example.com/', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('POST', 'https://www.example.com/baseball/blood', NULL, session_id);
			INSERT INTO request (method, url, params, session_id)
			VALUES ('PUT', 'http://example.com/boot', NULL, session_id);
		END LOOP;
		CLOSE cursor1;
	END;

CALL init_requests();