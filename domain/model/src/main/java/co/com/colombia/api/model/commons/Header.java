package co.com.colombia.api.model.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Header {

	@NotBlank(message = Constant.MESSAGE_TRANSACTION_TRACKER_NOT_BLANK)
	@HeaderName(Constant.TRANSACTION_TRACKER)
	@Pattern(regexp = RegularExpression.UUID, message = Constant.MESSAGE_TRANSACTION_TRACKER_FORMAT_UUID_REQUIRED)
	public String transactionTracker;

	@NotBlank(message = Constant.MESSAGE_SESSION_TRACKER_NOT_BLANK)
	@HeaderName(Constant.SESSION_TRACKER)
	@Pattern(regexp = RegularExpression.UUID, message = Constant.MESSAGE_SESSION_TRACKER_FORMAT_UUID_REQUIRED)
	public String sessionTracker;

	@NotBlank(message = Constant.MESSAGE_CHANNEL_NOT_BLANK)
	@Pattern(regexp = RegularExpression.ALPHABETICAL, message = Constant.MESSAGE_CHANNEL_ALPHABETICAL_REQUIRED)
	@Size(min=1, max=3, message = Constant.MESSAGE_CHANNEL_LENGTH_REQUIRED)
	@HeaderName(Constant.CHANNEL)
	public String channel;

	@NotBlank(message = Constant.MESSAGE_DATE_NOT_BLANK)
	@Pattern(regexp = RegularExpression.FORMAT_DATE, message =Constant.MESSAGE_DATE_FORMAT_REQUIRED)
	@Pattern(regexp = RegularExpression.RANGE_DATE, message =Constant.MESSAGE_DATE_RANGE_REQUIRED)
	@HeaderName(Constant.DATE)
	public String date;

	@NotBlank(message = Constant.MESSAGE_DATETIME_NOT_BLANK)
	@Pattern(regexp = RegularExpression.DATE_TIME, message = Constant.MESSAGE_DATETIME_FORMAT_REQUIRED)
	@Pattern(regexp = RegularExpression.RANGE_DATE_TIME, message = Constant.MESSAGE_DATETIME_RANGE_REQUIRED)
	@HeaderName(Constant.DATETIME)
	public String dateTime;

	@NotBlank(message = Constant.MESSAGE_IP_NOT_BLANK)
	@Pattern(regexp = RegularExpression.IPV4, message = Constant.MESSAGE_IP_FORMAT_REQUIRED)
	@HeaderName(Constant.IP)
	public String ip;

	@NotBlank(message = Constant.MESSAGE_CLIENT_ID_NOT_BLANK)
	@Pattern(regexp = RegularExpression.NUMERIC, message = Constant.MESSAGE_CLIENT_ID_FORMAT_REQUIRED)
	@Size(min = 1, max = 20, message = Constant.MESSAGE_CLIENT_ID_LENGTH_REQUIRED)
	@Pattern(regexp = RegularExpression.NOT_ZERO, message = Constant.MESSAGE_CLIENT_ID_NOT_ZERO)
	@HeaderName(Constant.CLIENT_ID)
	public String clientId;

	@NotBlank(message = Constant.MESSAGE_CLIENT_TYPE_NOT_BLANK)
//	@Pattern(regexp = RegularExpression.ALPHABETICAL, message = Constant.MESSAGE_CLIENT_TYPE_FORMAT_REQUIRED)
	@Size(min = 1, max = 4, message = Constant.MESSAGE_CLIENT_TYPE_LENGTH_REQUIRED)
	@HeaderName(Constant.CLIENT_TYPE)
	public String clientType;

	public String productId;

	public ErrorHeader errorHeader;

	public String pathRoute;


}