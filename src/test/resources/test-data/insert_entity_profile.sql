set @ENTITY_PROFILE_ID = '7577b899-c984-4570-8910-a20e24bff518';
insert into tbl_entity_profile (id, entity_name, entity_type) values (@ENTITY_PROFILE_ID, 'Merlion Tech', 'COM');
insert into tbl_employee_profile (id, name, entity_profile_id) values ('c6592c5d-5f0a-459a-9717-ae2f23b84801', 'John Doe', @ENTITY_PROFILE_ID);
insert into tbl_employee_profile (id, name, entity_profile_id) values ('dd05cdf6-d06c-4cb2-851b-8cd4c4a5a2b0', 'Mary Jane', @ENTITY_PROFILE_ID);