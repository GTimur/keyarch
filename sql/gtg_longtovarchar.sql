CREATE OR REPLACE FUNCTION XXI.GTGLongToVarchar(id varchar2) RETURN varchar2
IS
  ResVChar  varchar2(32767);
BEGIN
  SELECT k.publ_key
  INTO ResVChar
  FROM keys@ibank2lnk k
  WHERE id_key = id
  RETURN  ResVChar;
END;
