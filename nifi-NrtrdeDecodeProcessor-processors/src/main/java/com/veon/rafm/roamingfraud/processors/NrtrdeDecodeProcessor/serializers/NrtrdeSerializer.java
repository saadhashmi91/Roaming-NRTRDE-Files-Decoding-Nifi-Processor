package com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.serializers;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.collect.Lists;
import com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.nrtrde.CallEvent;
import com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.nrtrde.Nrtrde;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NrtrdeSerializer extends JsonSerializer<Nrtrde> {


      static class MOCJsonWrapper<T> {
        @JsonUnwrapped
        private T inner;
        private String fileUtcTime;
        private String Sender_OpCo;
        private String Recipient_OpCo;
        private String fileTimeStamp;
        private String fileSequenceNumber;
        private String event_type;
        private String CDR_Serial_Number;
        private String IMSI_Operator_Info;
        private String Sender_Country;
        private String Sender_Operator;
        private String Recipient_Country;
        private String Recipient_Operator;
        private String calling_Rates;
        private long Total_Cost;
        private String Event_Date;
        private String Duration_minutes;
        private String stamp;
        private String sr;
        private String TeleServiceCodeDesc;
        private String Called_Country;
        private String Call_Type;
        private String PRS;
        private String Traffic;
        private String Record_Processing_Time;
        //gprs specific
        private String accessPointNameNI;
        private String accessPointNameOI;
        private String DataDownloaded;
        private String DataUploaded;
        private String sgsnAddress;
        private String ggsnAddress;
        private String chargingId;

        public T getInner() {
            return inner;
        }

        public  String getAccessPointNameNI() {
            return accessPointNameNI;
        }public String getAccessPointNameOI() {
            return accessPointNameOI;
        }public String getDataDownloaded() {
            return DataDownloaded;
        }public String getDataUploaded() {
            return DataUploaded;
        }public String getSgsnAddress() {
            return sgsnAddress;
        }public String getGgsnAddress() {
            return ggsnAddress;
        }public String getChargingId() {
            return chargingId;
        }





        public String getFileUtcTime() {
            return fileUtcTime;
        }

        public String getSender_OpCo() {
            return Sender_OpCo;
        }

        public String getRecipient_OpCo() {
            return Recipient_OpCo;
        }

        public String getFileTimeStamp() {
            return fileTimeStamp;
        }

        public String getFileSequenceNumber() {
            return fileSequenceNumber;
        }

        public String getEvent_type() {
            return event_type;
        }

        public String getCDR_Serial_Number() {
            return CDR_Serial_Number;
        }

        public String getIMSI_Operator_Info() {
            return IMSI_Operator_Info;
        }

        public String getSender_Country() {
            return Sender_Country;
        }

        public String getSender_Operator() {
            return Sender_Operator;
        }

        public String getRecipient_Country() {
            return Recipient_Country;
        }

        public String getRecipient_Operator() {
            return Recipient_Operator;
        }

        public String getCalling_Rates() {
            return calling_Rates;
        }

        public long getTotal_Cost() {
            return Total_Cost;
        }

        public String getEvent_Date() {
            return Event_Date;
        }

        public String getDuration_minutes() {
            return Duration_minutes;
        }

        public String getStamp() {
            return stamp;
        }

        public String getSr() {
            return sr;
        }

        public String getTeleServiceCodeDesc() {
            return TeleServiceCodeDesc;
        }

        public String getCalled_Country() {
            return Called_Country;
        }

        public String getCall_Type() {
            return Call_Type;
        }

        public String getPRS() {
            return PRS;
        }

        public String getTraffic() {
            return Traffic;
        }

        public String getRecord_Processing_Time() {
            return Record_Processing_Time;
        }


        public MOCJsonWrapper(T inner,String fileUtcTime_input, String Sender_OpCo_input, String Recipient_OpCo_input, String fileTimeStamp_input, String fileSequenceNumber_input, String event_type_input, String CDR_Serial_Number_input, String IMSI_Operator_Info_input, String Sender_Country_input, String Sender_Operator_input, String Recipient_Country_input, String Recipient_Operator_input, String calling_Rates_input, long Total_Cost_input, String Event_Date_input, String Duration_minutes_input, String stamp_input, String sr_input, String TeleServiceCodeDesc_input, String Called_Country_input, String Call_Type_input, String PRS_input, String Traffic_input, String Record_Processing_Time_input,String accessPointNameNI_input,String accessPointNameOI_input,String DataDownloaded_input,String DataUploaded_input,String sgsnAddress_input,String ggsnAddress_input,String chargingId_input) {
            this.inner = inner;
            fileUtcTime=fileUtcTime_input;
            Sender_OpCo=Sender_OpCo_input;
            Recipient_OpCo=Recipient_OpCo_input;
            fileTimeStamp=fileTimeStamp_input;
            fileSequenceNumber=fileSequenceNumber_input;
            event_type=event_type_input;
            CDR_Serial_Number=CDR_Serial_Number_input;
            IMSI_Operator_Info=IMSI_Operator_Info_input;
            Sender_Country=Sender_Country_input;
            Sender_Operator=Sender_Operator_input;
            Recipient_Country=Recipient_Country_input;
            Recipient_Operator=Recipient_Operator_input;
            calling_Rates=calling_Rates_input;
            Total_Cost=Total_Cost_input;
            Event_Date=Event_Date_input;
            Duration_minutes=Duration_minutes_input;
            stamp=stamp_input;
            sr=sr_input;
            TeleServiceCodeDesc=TeleServiceCodeDesc_input;
            Called_Country=Called_Country_input;
            Call_Type=Call_Type_input;
            PRS=PRS_input;
            Traffic=Traffic_input;
            Record_Processing_Time=Record_Processing_Time_input;
            accessPointNameNI=accessPointNameNI_input;
            accessPointNameOI=accessPointNameOI_input;
            DataDownloaded=DataDownloaded_input;
            DataUploaded=DataUploaded_input;
            sgsnAddress=sgsnAddress_input;
            ggsnAddress=ggsnAddress_input;
            chargingId=chargingId_input;
        }




    }



     static class MTCJsonWrapper<T> {
        @JsonUnwrapped
        private T inner;
        private String fileUtcTime;
        private String Sender_OpCo;
        private String Recipient_OpCo;
        private String fileTimeStamp;
        private String fileSequenceNumber;
        private String event_type;
        private String CDR_Serial_Number;
        private String IMSI_Operator_Info;
        private String Sender_Country;
        private String Sender_Operator;
        private String Recipient_Country;
        private String Recipient_Operator;
        private String calling_Rates;
        private long Total_Cost;
        private String Event_Date;
        private String Duration_minutes;
        private String stamp;
        private String sr;
        private String TeleServiceCodeDesc;
        private String Called_Country;
        private String Call_Type;
        private String PRS;
        private String Traffic;
        private String Record_Processing_Time;
        //gprs specific
        private String accessPointNameNI;
        private String accessPointNameOI;
        private String DataDownloaded;
        private String DataUploaded;
        private String sgsnAddress;
        private String ggsnAddress;
        private String chargingId;

        //moc

        private String supplementaryServiceCode;
        private String dialledDigits;
        private String connectedNumber;
        private String thirdPartyNumber;

        public String getSupplementaryServiceCode() {
            return supplementaryServiceCode;
        }

        public String getDialledDigits() {
            return dialledDigits;
        }

        public String getConnectedNumber() {
            return connectedNumber;
        }

        public String getThirdPartyNumber() {
            return thirdPartyNumber;
        }

        public MTCJsonWrapper(T inner, String fileUtcTime, String sender_OpCo, String recipient_OpCo, String fileTimeStamp, String fileSequenceNumber, String event_type, String CDR_Serial_Number, String IMSI_Operator_Info, String sender_Country, String sender_Operator, String recipient_Country, String recipient_Operator, String calling_Rates, long total_Cost, String event_Date, String duration_minutes, String stamp, String sr, String teleServiceCodeDesc, String called_Country, String call_Type, String PRS, String traffic, String record_Processing_Time, String accessPointNameNI, String accessPointNameOI, String dataDownloaded, String dataUploaded, String sgsnAddress, String ggsnAddress, String chargingId, String supplementaryServiceCode, String dialledDigits, String connectedNumber, String thirdPartyNumber) {
            this.inner = inner;
            this.fileUtcTime = fileUtcTime;
            Sender_OpCo = sender_OpCo;
            Recipient_OpCo = recipient_OpCo;
            this.fileTimeStamp = fileTimeStamp;
            this.fileSequenceNumber = fileSequenceNumber;
            this.event_type = event_type;
            this.CDR_Serial_Number = CDR_Serial_Number;
            this.IMSI_Operator_Info = IMSI_Operator_Info;
            Sender_Country = sender_Country;
            Sender_Operator = sender_Operator;
            Recipient_Country = recipient_Country;
            Recipient_Operator = recipient_Operator;
            this.calling_Rates = calling_Rates;
            Total_Cost = total_Cost;
            Event_Date = event_Date;
            Duration_minutes = duration_minutes;
            this.stamp = stamp;
            this.sr = sr;
            TeleServiceCodeDesc = teleServiceCodeDesc;
            Called_Country = called_Country;
            Call_Type = call_Type;
            this.PRS = PRS;
            Traffic = traffic;
            Record_Processing_Time = record_Processing_Time;
            this.accessPointNameNI = accessPointNameNI;
            this.accessPointNameOI = accessPointNameOI;
            DataDownloaded = dataDownloaded;
            DataUploaded = dataUploaded;
            this.sgsnAddress = sgsnAddress;
            this.ggsnAddress = ggsnAddress;
            this.chargingId = chargingId;
            this.supplementaryServiceCode = supplementaryServiceCode;
            this.dialledDigits = dialledDigits;
            this.connectedNumber = connectedNumber;
            this.thirdPartyNumber = thirdPartyNumber;
        }



        public T getInner() {
            return inner;
        }

        public  String getAccessPointNameNI() {
            return accessPointNameNI;
        }public String getAccessPointNameOI() {
            return accessPointNameOI;
        }public String getDataDownloaded() {
            return DataDownloaded;
        }public String getDataUploaded() {
            return DataUploaded;
        }public String getSgsnAddress() {
            return sgsnAddress;
        }public String getGgsnAddress() {
            return ggsnAddress;
        }public String getChargingId() {
            return chargingId;
        }





        public String getFileUtcTime() {
            return fileUtcTime;
        }

        public String getSender_OpCo() {
            return Sender_OpCo;
        }

        public String getRecipient_OpCo() {
            return Recipient_OpCo;
        }

        public String getFileTimeStamp() {
            return fileTimeStamp;
        }

        public String getFileSequenceNumber() {
            return fileSequenceNumber;
        }

        public String getEvent_type() {
            return event_type;
        }

        public String getCDR_Serial_Number() {
            return CDR_Serial_Number;
        }

        public String getIMSI_Operator_Info() {
            return IMSI_Operator_Info;
        }

        public String getSender_Country() {
            return Sender_Country;
        }

        public String getSender_Operator() {
            return Sender_Operator;
        }

        public String getRecipient_Country() {
            return Recipient_Country;
        }

        public String getRecipient_Operator() {
            return Recipient_Operator;
        }

        public String getCalling_Rates() {
            return calling_Rates;
        }

        public long getTotal_Cost() {
            return Total_Cost;
        }

        public String getEvent_Date() {
            return Event_Date;
        }

        public String getDuration_minutes() {
            return Duration_minutes;
        }

        public String getStamp() {
            return stamp;
        }

        public String getSr() {
            return sr;
        }

        public String getTeleServiceCodeDesc() {
            return TeleServiceCodeDesc;
        }

        public String getCalled_Country() {
            return Called_Country;
        }

        public String getCall_Type() {
            return Call_Type;
        }

        public String getPRS() {
            return PRS;
        }

        public String getTraffic() {
            return Traffic;
        }

        public String getRecord_Processing_Time() {
            return Record_Processing_Time;
        }



    }



      static class GPRSJsonWrapper<T> {
        @JsonUnwrapped
        private T inner;
        private String fileUtcTime;
        private String Sender_OpCo;
        private String Recipient_OpCo;
        private String fileTimeStamp;
        private String fileSequenceNumber;
        private String event_type;
        private String CDR_Serial_Number;
        private String IMSI_Operator_Info;
        private String Sender_Country;
        private String Sender_Operator;
        private String Recipient_Country;
        private String Recipient_Operator;
        private String calling_Rates;
        private long Total_Cost;
        private String Event_Date;
        private String Duration_minutes;
        private String stamp;
        private String sr;
        private String TeleServiceCodeDesc;
        private String Called_Country;
        private String Call_Type;
        private String PRS;
        private String Traffic;
        private String Record_Processing_Time;
        //moc+mtc specific
        private String supplementaryServiceCode;
        private String dialledDigits;
        private String connectedNumber;
        private String thirdPartyNumber;
        private String teleServiceCode;
        private String bearerServiceCode;
        private String recEntityId;
        private long callReference;
        private String BNumber;

        public GPRSJsonWrapper(T inner, String fileUtcTime, String sender_OpCo, String recipient_OpCo, String fileTimeStamp, String fileSequenceNumber, String event_type, String CDR_Serial_Number, String IMSI_Operator_Info, String sender_Country, String sender_Operator, String recipient_Country, String recipient_Operator, String calling_Rates, long total_Cost, String event_Date, String duration_minutes, String stamp, String sr, String teleServiceCodeDesc, String called_Country, String call_Type, String PRS, String traffic, String record_Processing_Time, String supplementaryServiceCode, String dialledDigits, String connectedNumber, String thirdPartyNumber, String teleServiceCode, String bearerServiceCode, String recEntityId, long callReference, String BNumber) {
            this.inner = inner;
            this.fileUtcTime = fileUtcTime;
            Sender_OpCo = sender_OpCo;
            Recipient_OpCo = recipient_OpCo;
            this.fileTimeStamp = fileTimeStamp;
            this.fileSequenceNumber = fileSequenceNumber;
            this.event_type = event_type;
            this.CDR_Serial_Number = CDR_Serial_Number;
            this.IMSI_Operator_Info = IMSI_Operator_Info;
            Sender_Country = sender_Country;
            Sender_Operator = sender_Operator;
            Recipient_Country = recipient_Country;
            Recipient_Operator = recipient_Operator;
            this.calling_Rates = calling_Rates;
            Total_Cost = total_Cost;
            Event_Date = event_Date;
            Duration_minutes = duration_minutes;
            this.stamp = stamp;
            this.sr = sr;
            TeleServiceCodeDesc = teleServiceCodeDesc;
            Called_Country = called_Country;
            Call_Type = call_Type;
            this.PRS = PRS;
            Traffic = traffic;
            Record_Processing_Time = record_Processing_Time;
            this.supplementaryServiceCode = supplementaryServiceCode;
            this.dialledDigits = dialledDigits;
            this.connectedNumber = connectedNumber;
            this.thirdPartyNumber = thirdPartyNumber;
            this.teleServiceCode = teleServiceCode;
            this.bearerServiceCode = bearerServiceCode;
            this.recEntityId = recEntityId;
            this.callReference = callReference;
            this.BNumber = BNumber;
        }


        public String getSupplementaryServiceCode() {
            return supplementaryServiceCode;
        }

        public String getDialledDigits() {
            return dialledDigits;
        }

        public String getConnectedNumber() {
            return connectedNumber;
        }

        public String getThirdPartyNumber() {
            return thirdPartyNumber;
        }

        public String getTeleServiceCode() {
            return teleServiceCode;
        }

        public String getBearerServiceCode() {
            return bearerServiceCode;
        }

        public String getRecEntityId() {
            return recEntityId;
        }

        public long getCallReference() {
            return callReference;
        }

        public String getBNumber() {
            return BNumber;
        }





        public String getFileUtcTime() {
            return fileUtcTime;
        }

        public String getSender_OpCo() {
            return Sender_OpCo;
        }

        public String getRecipient_OpCo() {
            return Recipient_OpCo;
        }

        public String getFileTimeStamp() {
            return fileTimeStamp;
        }

        public String getFileSequenceNumber() {
            return fileSequenceNumber;
        }

        public String getEvent_type() {
            return event_type;
        }

        public String getCDR_Serial_Number() {
            return CDR_Serial_Number;
        }

        public String getIMSI_Operator_Info() {
            return IMSI_Operator_Info;
        }

        public String getSender_Country() {
            return Sender_Country;
        }

        public String getSender_Operator() {
            return Sender_Operator;
        }

        public String getRecipient_Country() {
            return Recipient_Country;
        }

        public String getRecipient_Operator() {
            return Recipient_Operator;
        }

        public String getCalling_Rates() {
            return calling_Rates;
        }

        public long getTotal_Cost() {
            return Total_Cost;
        }

        public String getEvent_Date() {
            return Event_Date;
        }

        public String getDuration_minutes() {
            return Duration_minutes;
        }

        public String getStamp() {
            return stamp;
        }

        public String getSr() {
            return sr;
        }

        public String getTeleServiceCodeDesc() {
            return TeleServiceCodeDesc;
        }

        public String getCalled_Country() {
            return Called_Country;
        }

        public String getCall_Type() {
            return Call_Type;
        }

        public String getPRS() {
            return PRS;
        }

        public String getTraffic() {
            return Traffic;
        }

        public String getRecord_Processing_Time() {
            return Record_Processing_Time;
        }

        public T getInner() {
            return inner;
        }


    }


  public  static class CallEventContract{

        private String imsi;
        private String imei;
        private String EventStartTimeStamp;
        private String utcTimeOffset;
        private long Duration;
        private long causeForTermination;
        //private String chargingAmount;
        private String servingNetwork;
        private String msisdn;
        private String locationArea;
        private String cellId;
        private String BNumber;


      private String connectedNumber;
      private String thirdPartyNumber;
      private String teleServiceCode;

      public String getConnectedNumber() {
          return connectedNumber;
      }

      public String getThirdPartyNumber() {
          return thirdPartyNumber;
      }

      public String getSupplementaryServiceCode() {
          return supplementaryServiceCode;
      }

      private String bearerServiceCode;
      private String supplementaryServiceCode;
        private String recEntityId;
        private long callReference;
        private String fileUtcTime;
        private String Sender_OpCo;
        private String Recipient_OpCo;
        private String fileTimeStamp;
        private String fileSequenceNumber;
        private String event_type;
        private String CDR_Serial_Number;
        private String IMSI_Operator_Info;
        private String Sender_Country;
        private String Sender_Operator;
        private String Recipient_Country;
        private String Recipient_Operator;
        private String calling_Rates;
        private long Total_Cost;
        private String Event_Date;
        private String Duration_minutes;
        private String stamp;
        private String sr;
        private String TeleServiceCodeDesc;
        private String Called_Country;
        private String Call_Type;
        private String PRS;
        private String Traffic;
        private String Record_Processing_Time;
        private String accessPointNameNI;
        private String accessPointNameOI;
        private String DataDownloaded;
        private String DataUploaded;
        private String sgsnAddress;
        private String ggsnAddress;
        private String chargingId;

        public String getImsi() {
            return imsi;
        }

        public String getImei() {
            return imei;
        }

        public String getEventStartTimeStamp() {
            return EventStartTimeStamp;
        }

        public String getUtcTimeOffset() {
            return utcTimeOffset;
        }

        public long getDuration() {
            return Duration;
        }

        public long getCauseForTermination() {
            return causeForTermination;
        }



        public String getServingNetwork() {
            return servingNetwork;
        }

        public String getMsisdn() {
            return msisdn;
        }

        public String getLocationArea() {
            return locationArea;
        }

        public String getCellId() {
            return cellId;
        }

        public String getBNumber() {
            return BNumber;
        }

        public String getTeleServiceCode() {
            return teleServiceCode;
        }

        public String getBearerServiceCode() {
            return bearerServiceCode;
        }

        public String getRecEntityId() {
            return recEntityId;
        }

        public long getCallReference() {
            return callReference;
        }

        public String getFileUtcTime() {
            return fileUtcTime;
        }

        public String getSender_OpCo() {
            return Sender_OpCo;
        }

        public String getRecipient_OpCo() {
            return Recipient_OpCo;
        }

        public String getFileTimeStamp() {
            return fileTimeStamp;
        }

        public String getFileSequenceNumber() {
            return fileSequenceNumber;
        }

        public String getEvent_type() {
            return event_type;
        }

        public String getCDR_Serial_Number() {
            return CDR_Serial_Number;
        }

        public String getIMSI_Operator_Info() {
            return IMSI_Operator_Info;
        }

        public String getSender_Country() {
            return Sender_Country;
        }

        public String getSender_Operator() {
            return Sender_Operator;
        }

        public String getRecipient_Country() {
            return Recipient_Country;
        }

        public String getRecipient_Operator() {
            return Recipient_Operator;
        }

        public String getCalling_Rates() {
            return calling_Rates;
        }

        public long getTotal_Cost() {
            return Total_Cost;
        }

        public String getEvent_Date() {
            return Event_Date;
        }

        public String getDuration_minutes() {
            return Duration_minutes;
        }

        public String getStamp() {
            return stamp;
        }

        public String getSr() {
            return sr;
        }

        public String getTeleServiceCodeDesc() {
            return TeleServiceCodeDesc;
        }

        public String getCalled_Country() {
            return Called_Country;
        }

        public String getCall_Type() {
            return Call_Type;
        }

        public String getPRS() {
            return PRS;
        }

        public String getTraffic() {
            return Traffic;
        }

        public String getRecord_Processing_Time() {
            return Record_Processing_Time;
        }

        public String getAccessPointNameNI() {
            return accessPointNameNI;
        }

        public String getAccessPointNameOI() {
            return accessPointNameOI;
        }

        public String getDataDownloaded() {
            return DataDownloaded;
        }

        public String getDataUploaded() {
            return DataUploaded;
        }

        public String getSgsnAddress() {
            return sgsnAddress;
        }

        public String getGgsnAddress() {
            return ggsnAddress;
        }

        public String getChargingId() {
            return chargingId;
        }


      public CallEventContract(String imsi, String imei, String eventStartTimeStamp, String utcTimeOffset, long duration, long causeForTermination, String servingNetwork, String msisdn, String locationArea, String cellId, String BNumber, String connectedNumber, String thirdPartyNumber, String teleServiceCode, String bearerServiceCode, String supplementaryServiceCode, String recEntityId, long callReference, String fileUtcTime, String sender_OpCo, String recipient_OpCo, String fileTimeStamp, String fileSequenceNumber, String event_type, String CDR_Serial_Number, String IMSI_Operator_Info, String sender_Country, String sender_Operator, String recipient_Country, String recipient_Operator, String calling_Rates, long total_Cost, String event_Date, String duration_minutes, String stamp, String sr, String teleServiceCodeDesc, String called_Country, String call_Type, String PRS, String traffic, String record_Processing_Time, String accessPointNameNI, String accessPointNameOI, String dataDownloaded, String dataUploaded, String sgsnAddress, String ggsnAddress, String chargingId) {
          this.imsi = imsi;
          this.imei = imei;
          EventStartTimeStamp = eventStartTimeStamp;
          this.utcTimeOffset = utcTimeOffset;
          Duration = duration;
          this.causeForTermination = causeForTermination;
          this.servingNetwork = servingNetwork;
          this.msisdn = msisdn;
          this.locationArea = locationArea;
          this.cellId = cellId;
          this.BNumber = BNumber;
          this.connectedNumber = connectedNumber;
          this.thirdPartyNumber = thirdPartyNumber;
          this.teleServiceCode = teleServiceCode;
          this.bearerServiceCode = bearerServiceCode;
          this.supplementaryServiceCode = supplementaryServiceCode;
          this.recEntityId = recEntityId;
          this.callReference = callReference;
          this.fileUtcTime = fileUtcTime;
          Sender_OpCo = sender_OpCo;
          Recipient_OpCo = recipient_OpCo;
          this.fileTimeStamp = fileTimeStamp;
          this.fileSequenceNumber = fileSequenceNumber;
          this.event_type = event_type;
          this.CDR_Serial_Number = CDR_Serial_Number;
          this.IMSI_Operator_Info = IMSI_Operator_Info;
          Sender_Country = sender_Country;
          Sender_Operator = sender_Operator;
          Recipient_Country = recipient_Country;
          Recipient_Operator = recipient_Operator;
          this.calling_Rates = calling_Rates;
          Total_Cost = total_Cost;
          Event_Date = event_Date;
          Duration_minutes = duration_minutes;
          this.stamp = stamp;
          this.sr = sr;
          TeleServiceCodeDesc = teleServiceCodeDesc;
          Called_Country = called_Country;
          Call_Type = call_Type;
          this.PRS = PRS;
          Traffic = traffic;
          Record_Processing_Time = record_Processing_Time;
          this.accessPointNameNI = accessPointNameNI;
          this.accessPointNameOI = accessPointNameOI;
          DataDownloaded = dataDownloaded;
          DataUploaded = dataUploaded;
          this.sgsnAddress = sgsnAddress;
          this.ggsnAddress = ggsnAddress;
          this.chargingId = chargingId;
      }






    }




    /* public NrtrdeSerializer() {
        this(null);
    }
*/
  /* public NrtrdeSerializer(Class<Nrtrde> t) {
        super(t);
    }
*/
    @Override
    public void serialize(Nrtrde ntrdrde, JsonGenerator jsonGenerator, SerializerProvider serializer) {
       try {
           jsonGenerator.writeStartObject();
           List<CallEvent> callEvents=ntrdrde.getCallEvents().getCallEvent();
/*
           List<CallEventContract> modInputs = Lists.transform(callEvents.stream().filter(p-> p.getMoc()!=null)
                                                    .collect(Collectors.toList()),
                   base -> new CallEventContract(
                           base.getMoc().getImsi().toString(),
                           base.getMoc().getImei().toString(),
                           base.getMoc().getCallEventStartTimeStamp().toString(),
                           base.getMoc().getUtcTimeOffset().toString(),
                           base.getMoc().getCallEventDuration().value.longValue(),
                           base.getMoc().getCauseForTermination().value.longValue(),
                           base.getMoc().getServingNetwork().toString(),
                           base.getMoc().getMsisdn().toString(),
                           base.getMoc().getLocationArea().value.toString(),
                           base.getMoc().getCellId().value.toString(),
                           base.getMoc().getDialledDigits().value.toString(),
                           base.getMoc().getServiceCode().getTeleServiceCode().value.toString(),
                           base.getMoc().getServiceCode().getBearerServiceCode().toString(),
                           base.getMoc().getRecEntityId().toString(),
                           base.getMoc().getCallReference().value.longValue(),
                           ntrdrde.getUtcTimeOffset().toString(),
                           null,
                           null,
                           ntrdrde.getFileAvailableTimeStamp().toString(),
                           ntrdrde.getSequenceNumber().toString(),
                           "moc",
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           0,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null,
                           null));
           jsonGenerator.writeString(modInputs.toString());
  */         jsonGenerator.writeEndObject();
       } catch (Exception e){}
    }

}
