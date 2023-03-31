\c electronichome;/*If you are not on the specified DB*/

create user general with password 'postgresql';
alter user general with superuser;