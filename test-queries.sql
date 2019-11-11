begin 
  DBMS_LOGMNR.START_LOGMNR(STARTSCN => 3392257,OPTIONS =>  DBMS_LOGMNR.SKIP_CORRUPTION+DBMS_LOGMNR.NO_SQL_DELIMITER+DBMS_LOGMNR.NO_ROWID_IN_STMT+DBMS_LOGMNR.DICT_FROM_ONLINE_CATALOG + DBMS_LOGMNR.CONTINUOUS_MINE+DBMS_LOGMNR.COMMITTED_DATA_ONLY+dbms_logmnr.STRING_LITERALS_IN_STMT)
; end;

SELECT thread#, scn, start_scn, commit_scn,timestamp, operation_code, operation,status, SEG_TYPE_NAME ,info,seg_owner, table_name, username, sql_redo ,row_id, csf, TABLE_SPACE, SESSION_INFO, RS_ID, RBASQN, RBABLK, SEQUENCE#, TX_NAME, SEG_NAME, SEG_TYPE_NAME FROM  v$logmnr_contents  WHERE OPERATION_CODE in (1,2,3) and commit_scn>= 3392257 and ((SEG_OWNER='ATA_BOS_READ'))
