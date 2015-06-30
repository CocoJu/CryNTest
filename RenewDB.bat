set MYSQL=C:\xampp\mysql\bin\mysql.exe
%MYSQL% --host=localhost --user=root  --database=paydb < .\sql\renew.sql
%MYSQL% --host=localhost --user=root  --database=paydb < .\sql\payment_base.sql
%MYSQL% --host=localhost --user=root  --database=paydb < .\sql\additional_script.sql