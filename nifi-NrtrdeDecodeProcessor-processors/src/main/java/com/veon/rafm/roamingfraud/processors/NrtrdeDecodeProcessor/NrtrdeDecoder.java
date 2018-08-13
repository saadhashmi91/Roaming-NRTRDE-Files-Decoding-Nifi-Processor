/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.common.collect.Lists;
import com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.nrtrde.CallEvent;
import com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.nrtrde.Nrtrde;
import org.apache.commons.io.IOUtils;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.annotation.behavior.ReadsAttribute;
import org.apache.nifi.annotation.behavior.ReadsAttributes;
import org.apache.nifi.annotation.behavior.WritesAttribute;
import org.apache.nifi.annotation.behavior.WritesAttributes;
import org.apache.nifi.annotation.lifecycle.OnScheduled;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.processor.exception.ProcessException;
import org.apache.nifi.processor.AbstractProcessor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.ProcessSession;
import org.apache.nifi.processor.ProcessorInitializationContext;
import org.apache.nifi.processor.Relationship;
import org.apache.nifi.processor.io.InputStreamCallback;
import org.apache.nifi.processor.io.OutputStreamCallback;
import org.apache.nifi.processor.util.StandardValidators;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Tags({"NrtrdeDecoder","veon.rafm.roamingfraud"})
@CapabilityDescription("Decodes incoming Nrtrde Files to JSON")
@SeeAlso({})
@ReadsAttributes({@ReadsAttribute(attribute="", description="")})
@WritesAttributes({@WritesAttribute(attribute="", description="")})
public class NrtrdeDecoder extends AbstractProcessor {

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
        private String sender;

        public String getSender() {
            return sender;
        }

        public String getRecipient() {
            return recipient;
        }

        private String recipient;
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
        private String EventStartTime;
        private String Event_Date;
        private long Duration_minutes;
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

        public String getEventStartTime() {
            return EventStartTime;
        }

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

        public long getDuration_minutes() {
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


        public CallEventContract(String imsi, String imei, String eventStartTimeStamp, String utcTimeOffset, long duration, long causeForTermination, String servingNetwork, String msisdn, String locationArea, String cellId, String BNumber, String connectedNumber, String thirdPartyNumber, String teleServiceCode, String bearerServiceCode, String supplementaryServiceCode, String recEntityId, long callReference, String fileUtcTime, String sender_OpCo, String recipient_OpCo, String fileTimeStamp, String fileSequenceNumber, String event_type, String CDR_Serial_Number, String IMSI_Operator_Info, String sender_Country, String sender_Operator, String recipient_Country, String recipient_Operator, String calling_Rates, long total_Cost,String eventStartTime, String event_Date, long duration_minutes, String stamp, String sr, String teleServiceCodeDesc, String called_Country, String call_Type, String PRS, String traffic, String record_Processing_Time, String accessPointNameNI, String accessPointNameOI, String dataDownloaded, String dataUploaded, String sgsnAddress, String ggsnAddress, String chargingId) {
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
            sender = sender_OpCo;
            recipient = recipient_OpCo;
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
            this.Duration_minutes = duration_minutes;
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


    public static final Relationship SUCCESS = new Relationship.Builder()
            .name("SUCCESS")
            .description("Decoded Files")
            .build();

    public static final Relationship FAILURE = new Relationship.Builder()
            .name("FAILURE")
            .description("Failed Files")
            .build();

    private List<PropertyDescriptor> descriptors;

    private Set<Relationship> relationships;

    @Override
    protected void init(final ProcessorInitializationContext context) {
        final List<PropertyDescriptor> descriptors = new ArrayList<PropertyDescriptor>();
        //descriptors.add(MY_PROPERTY);
        //this.descriptors = Collections.unmodifiableList(descriptors);

        final Set<Relationship> relationships = new HashSet<Relationship>();
        relationships.add(SUCCESS);
        relationships.add(FAILURE);
        this.relationships = Collections.unmodifiableSet(relationships);
    }

    @Override
    public Set<Relationship> getRelationships() {
        return this.relationships;
    }

    @Override
    public final List<PropertyDescriptor> getSupportedPropertyDescriptors() {
        return descriptors;
    }

    @OnScheduled
    public void onScheduled(final ProcessContext context) {

    }

    @Override
    public void onTrigger(final ProcessContext context, final ProcessSession session) throws ProcessException {
        FlowFile flowFile = session.get();
        if ( flowFile == null ) {
            return;
        }
        // TODO implement
        final AtomicReference<String> value = new AtomicReference<>();
try{
        session.read(flowFile, new InputStreamCallback() {
            @Override
            public void process(InputStream in) throws IOException {

                    byte[] bytes = IOUtils.toByteArray(in);
                    InputStream is = new ByteArrayInputStream(bytes);
                    Nrtrde event_decoded = new Nrtrde();
                    event_decoded.decode(is);

                   // ObjectMapper mapper = new ObjectMapper();
                    //String jsonInString = mapper.writeValueAsString(event_decoded);

                List<CallEvent> callEvents=event_decoded.getCallEvents().getCallEvent();
                List<CallEventContract> mocInputs = Lists.transform(callEvents.stream().filter(p-> p.getMoc()!=null)
                                .collect(Collectors.toList()),
                        base -> new CallEventContract(
                                base.getMoc().getImsi().toString().replaceAll("F",""),
                                base.getMoc().getImei()==null?"":base.getMoc().getImei().toString().replaceAll("F",""),
                                new String(base.getMoc().getCallEventStartTimeStamp().value),
                                new String(base.getMoc().getUtcTimeOffset().value),
                                base.getMoc().getCallEventDuration().value.longValue(),
                                base.getMoc().getCauseForTermination().value.longValue(),
                                base.getMoc().getServingNetwork()==null?"":new String(base.getMoc().getServingNetwork().value).toString(),
                                base.getMoc().getMsisdn()==null?"":new String(base.getMoc().getMsisdn().value),
                                base.getMoc().getLocationArea()==null?"":base.getMoc().getLocationArea().value.toString(),
                                base.getMoc().getCellId()==null?"":base.getMoc().getCellId().value.toString(),
                                base.getMoc().getDialledDigits()==null?base.getMoc().getConnectedNumber()==null?"0":new String(base.getMoc().getConnectedNumber().value):new String(base.getMoc().getDialledDigits().value),
                                base.getMoc().getConnectedNumber()==null?"":new String(base.getMoc().getConnectedNumber().value),
                                base.getMoc().getThirdPartyNumber()==null?"":new String(base.getMoc().getThirdPartyNumber().value),
                                base.getMoc().getServiceCode()==null?"":base.getMoc().getServiceCode().getTeleServiceCode()==null?"":new String(base.getMoc().getServiceCode().getTeleServiceCode().value),
                                base.getMoc().getServiceCode().getBearerServiceCode()==null?"":new String(base.getMoc().getServiceCode().getBearerServiceCode().value),
                                base.getMoc().getSupplementaryServiceCode()==null?"":new String (base.getMoc().getSupplementaryServiceCode().value),
                                base.getMoc().getRecEntityId()==null?"":new String(base.getMoc().getRecEntityId().value),
                                base.getMoc().getCallReference()==null?0:base.getMoc().getCallReference().value.longValue(),
                                new String(event_decoded.getUtcTimeOffset().value),
                                new String(event_decoded.getSender().value),
                                new String(event_decoded.getRecipient().value),
                                new String(event_decoded.getFileAvailableTimeStamp().value),
                                new String(event_decoded.getSequenceNumber().value),
                                "moc",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                0,
                                "",
                                "",
                                0,
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                null));

                List<CallEventContract> mtcInputs = Lists.transform(callEvents.stream().filter(p-> p.getMtc()!=null)
                                .collect(Collectors.toList()),
                        base -> new CallEventContract(base.getMtc().getImsi().toString().replaceAll("F",""),
                                base.getMtc().getImei()==null?"":base.getMtc().getImei().toString().replaceAll("F",""),
                                new String(base.getMtc().getCallEventStartTimeStamp().value),
                                new String(base.getMtc().getUtcTimeOffset().value),
                                base.getMtc().getCallEventDuration().value.longValue(),
                                base.getMtc().getCauseForTermination().value.longValue(),
                                base.getMtc().getServingNetwork()==null?"":new String(base.getMtc().getServingNetwork().value).toString(),
                                base.getMtc().getMsisdn()==null?"":new String(base.getMtc().getMsisdn().value),
                                base.getMtc().getLocationArea()==null?"":base.getMtc().getLocationArea().value.toString(),
                                base.getMtc().getCellId()==null?"":base.getMtc().getCellId().value.toString(),
                                base.getMtc().getCallingNumber()==null?"":new String(base.getMtc().getCallingNumber().value),
                                "",
                                "",
                                base.getMtc().getServiceCode()==null?"":base.getMtc().getServiceCode().getTeleServiceCode()==null?"":new String(base.getMtc().getServiceCode().getTeleServiceCode().value),
                                base.getMtc().getServiceCode().getBearerServiceCode()==null?"":new String(base.getMtc().getServiceCode().getBearerServiceCode().value),
                                "",
                                base.getMtc().getRecEntityId()==null?"":new String(base.getMtc().getRecEntityId().value),
                                base.getMtc().getCallReference()==null?0:base.getMtc().getCallReference().value.longValue(),
                                new String(event_decoded.getUtcTimeOffset().value),
                                new String(event_decoded.getSender().value),
                                new String(event_decoded.getRecipient().value),
                                new String(event_decoded.getFileAvailableTimeStamp().value),
                                new String(event_decoded.getSequenceNumber().value),
                                "mtc",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                0,
                                "",
                                "",
                                0,
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                null));


                List<CallEventContract> gprsInputs = Lists.transform(callEvents.stream().filter(p-> p.getGprs()!=null)
                                .collect(Collectors.toList()),
                        base -> new CallEventContract(base.getGprs().getImsi().toString().replaceAll("F",""),
                                base.getGprs().getImei()==null?"":base.getGprs().getImei().toString().replaceAll("F",""),
                                new String(base.getGprs().getCallEventStartTimeStamp().value),
                                new String(base.getGprs().getUtcTimeOffset().value),
                                base.getGprs().getCallEventDuration().value.longValue(),
                                base.getGprs().getCauseForTermination().value.longValue(),
                                base.getGprs().getServingNetwork()==null?"":new String(base.getGprs().getServingNetwork().value).toString(),
                                base.getGprs().getMsisdn()==null?"":new String(base.getGprs().getMsisdn().value),
                                base.getGprs().getLocationArea()==null?"":base.getGprs().getLocationArea().value.toString(),
                                base.getGprs().getCellId()==null?"":base.getGprs().getCellId().value.toString(),
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                0,
                                new String(event_decoded.getUtcTimeOffset().value),
                                new String(event_decoded.getSender().value),
                                new String(event_decoded.getRecipient().value),
                                new String(event_decoded.getFileAvailableTimeStamp().value),
                                new String(event_decoded.getSequenceNumber().value),
                                "gprs",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                0,
                                "",
                                "",
                                0,
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                base.getGprs().getAccessPointNameNI()==null?"":new String(base.getGprs().getAccessPointNameNI().value),
                                base.getGprs().getAccessPointNameOI()==null?"":new String(base.getGprs().getAccessPointNameOI().value),
                                base.getGprs().getDataVolumeIncoming()==null?"":base.getGprs().getDataVolumeIncoming().value.toString(),
                                base.getGprs().getDataVolumeOutgoing()==null?"":base.getGprs().getDataVolumeOutgoing().value.toString(),
                                base.getGprs().getSgsnAddress()==null?"":new String(base.getGprs().getSgsnAddress().value),
                                base.getGprs().getGgsnAddress()==null?"":new String(base.getGprs().getGgsnAddress().value),
                                base.getGprs().getChargingId()==null?"":base.getGprs().getChargingId().value.toString()));

                List<CallEventContract> finalList=new ArrayList<>();
               // if(mocInputs!=null)
                    finalList.addAll(mocInputs);
               // if(mtcInputs!=null)
                    finalList.addAll(mtcInputs);
               // if(gprsInputs!=null)
                    finalList.addAll(gprsInputs);
/*
                finalList.sort(new Comparator<CallEventContract>(){

                    @Override
                    public int compare(CallEventContract m1,CallEventContract  m2) {
                        try {
                            if (new Timestamp(new SimpleDateFormat(
                                    "yyyyMMddhhmmss").parse(m1.getEventStartTimeStamp()).getTime()).before(new Timestamp(new SimpleDateFormat(
                                    "yyyyMMddhhmmss").parse(m2.getEventStartTimeStamp()).getTime()))) {
                                return 0;
                            }
                            else return 1;

                        }catch (Exception ex){
                            //  ex.printStackTrace();

                        }
                        return 0;
                    }


                });*/

                finalList.removeAll(Collections.singleton(null));

                ObjectMapper mapper = new ObjectMapper();
                // mapper.registerModule(module1);
                // mapper.registerModule()


                // mapper.enable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);

                // startTime = System.nanoTime();
                String jsonInString = mapper.writeValueAsString(finalList);
                    value.set(jsonInString);

            }
        });
        // To write the results back out ot flow file
        flowFile = session.write(flowFile, new OutputStreamCallback() {

            @Override
            public void process(OutputStream out) throws IOException {
                out.write(value.get().getBytes());
            }
        });
        session.transfer(flowFile, SUCCESS);

}catch(Exception ex){
    ex.printStackTrace();
    getLogger().error("Failed to read decode Nrtrde file:"+ex.getMessage());
    session.transfer(flowFile, FAILURE);

}


    }
}
