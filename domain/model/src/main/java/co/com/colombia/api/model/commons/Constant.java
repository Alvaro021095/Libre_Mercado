package co.com.colombia.api.model.commons;

import java.util.HashMap;
import java.util.Map;

public class Constant {

    //Nombres Headers
    public static final String TRANSACTION_TRACKER= "Transaction-Tracker";
    public static final String SESSION_TRACKER= "Session-Tracker";
    public static final String CHANNEL= "Channel";
    public static final String DATE= "Date";
    public static final String DATETIME= "DateTime";
    public static final String IP= "Ip";
    public static final String CLIENT_ID= "ClientID";
    public static final String CLIENT_TYPE= "ClientType";

    //Mensajes para la cabecera Transaction-Tracker
    public static final String MESSAGE_TRANSACTION_TRACKER_NOT_BLANK
            = "CODE-001;La cabecera 'Transaction-Tracker' Es requerida.";
    public static final String MESSAGE_TRANSACTION_TRACKER_FORMAT_UUID_REQUIRED
            = "CODE-002;La cabecera 'Transaction-Tracker' Debe cumplir el formato UUID";

    //Mensajes para la cabecera Session-Tracker
    public static final String MESSAGE_SESSION_TRACKER_NOT_BLANK
            = "CODE-003;La cabecera 'Session-Tracker' Es requerida.";
    public static final String MESSAGE_SESSION_TRACKER_FORMAT_UUID_REQUIRED
            = "CODE-004;La cabecera 'Session-Tracker' debe cumplir con el formado UUID";

    //Mensajes para la cabecera Channel
    public static final String MESSAGE_CHANNEL_NOT_BLANK = "CODE-005;La cabecera 'Channel' Es requerida.";
    public static final String MESSAGE_CHANNEL_ALPHABETICAL_REQUIRED
            = "CODE-005;La cabecera 'Channel' Solo acepta letras mayusculas.";
    public static final String MESSAGE_CHANNEL_LENGTH_REQUIRED
            = "CODE-006;La cabecera 'Channel' Debe cumplir con la longitud requerida entre 1 y 3 caracteres.";

    //Mensajes para la cabecera Date
    public static final String MESSAGE_DATE_NOT_BLANK= "CODE-007;La cabecera 'Date' Es requerida.";
    public static final String MESSAGE_DATE_FORMAT_REQUIRED
            = "CODE-008;La cabecera 'Date' Debe cumplir con el formato 'yyyy/MM/dd'";
    public static final String MESSAGE_DATE_RANGE_REQUIRED
            = "CODE-009;La cabecera 'Date' Debe cumplir con un rango valido para las fechas.";

    //Mensajes para la cabecera DateTime
    public static final String MESSAGE_DATETIME_NOT_BLANK= "CODE-010;La cabecera 'DateTime' Es requerida.";
    public static final String MESSAGE_DATETIME_FORMAT_REQUIRED
            = "CODE-011;La cabecera 'DateTime' Debe cumplir con el formato HH:mm:ss";
    public static final String MESSAGE_DATETIME_RANGE_REQUIRED
            = "CODE-012;La cabecera 'DateTime' Debe cumplir con un rango valido para las horas, minutos o segundos.";

    //Mensajes para la cabecera Ip
    public static final String MESSAGE_IP_NOT_BLANK= "CODE-013;La cabecera 'Ip' Es requerida.";
    public static final String MESSAGE_IP_FORMAT_REQUIRED
            = "CODE-014;La cabecera 'Ip' Debe cumplor co un valor en el siguiente rango 1.1.1.1 - 255.255.255.255";

    //Mensajes para la cabecera ClientId
    public static final String MESSAGE_CLIENT_ID_NOT_BLANK = "CODE-015;La cabecera 'ClientID' Es requerida.";
    public static final String MESSAGE_CLIENT_ID_FORMAT_REQUIRED
            = "CODE-016;La cabecera 'ClientID' solo acepta numeros positivos.";
    public static final String MESSAGE_CLIENT_ID_LENGTH_REQUIRED
            = "CODE-017;La cabecera 'ClientID' debe cumplir con la longitud requerida de 1 a 20 digitos.";
    public static final String MESSAGE_CLIENT_ID_NOT_ZERO
            = "CODE-018;La cabecera 'ClientID' debe empezar por un valor entre 1 y 9 (1-9)";

    //Mensajes para la cabecera ClientType
    public static final String MESSAGE_CLIENT_TYPE_NOT_BLANK = "CODE-019;La cabecera 'ClientType' Es requerida.";
    public static final String MESSAGE_CLIENT_TYPE_FORMAT_REQUIRED
            = "CODE-020;La cabecera 'ClientType' Solo acepta letras mayusculas.";
    public static final String MESSAGE_CLIENT_TYPE_LENGTH_REQUIRED
            = "CODE-021;La cabecera 'ClientType' Debe cumplir con una longitud entre 1 y 3 .";


    //Mensajes para la cabecera initialDt
    public static final String MESSAGE_INITIAL_DT_NOT_BLANK = "CODE-022;La cabecera 'initialDt' Es requerida.";
    public static final String MESSAGE_INITIAL_DT_FORMAT_REQUIRED
            = "CODE-023;La cabecera 'initialDt' Debe cumplir con el Formato requerido 'yyyy-MM-dd'";
    public static final String MESSAGE_INITIAL_DT_RANGE_REQUIRED
            = "CODE-024;La cabecera 'initialDt' invalido, Rango de fechas invalido.";


    public static final String MESSAGE_GET_BALANCE_BODY_REQUIRED
            = "REC100;El Objeto 'RechargeRequestrechargeRequest' No tiene la estructura requerida.";

    public static final String MESSAGE_GET_BALANCE_BODY_PRODUCT_INFO_REQUIRED
            ="REC101;No contiene el objeto 'ProductInformation' Requerido.";

    public static final String MESSAGE_GET_BALANCE_BODY_FIRST_REQUIRED
            = "REC102;No contiene el campo 'firstReference'";

    public static final String MESSAGE_GET_BALANCE_BODY_SECOND_REQUIRED
            = "REC103;No contiene el campo 'secondReference'";

    public static final String MESSAGE_GET_BALANCE_BODY_SECOND_MAX_REQUIRED
            = "REC104;El campo 'secondReference' Contiene mas de 100 caracteres. ";

    //Producto recharge
    public static final String ORCHESTRATOR_PRUEBA = "recharge";
    public static final String PRODUCT_ID = "productId";

    private Constant() {
		super();
	}


}
