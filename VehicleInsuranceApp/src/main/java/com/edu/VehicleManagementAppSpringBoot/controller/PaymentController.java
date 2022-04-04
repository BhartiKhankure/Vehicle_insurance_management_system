//package com.edu.VehicleManagementAppSpringBoot.controller;
//
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.TreeMap;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import com.paytm.pg.merchant.PaytmChecksum;
//
//import com.edu.VehicleManagementAppSpringBoot.entity.PaymentDetails;
//
//@Controller
//public class PaymentController {
//	
//		
//	//@Autowired
//		private PaymentDetails paymentDetails;
//		
//		public PaymentController() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//		
//
//	//	@Autowired
//		private Environment env;
//		
//		@GetMapping("/user/payment/{id}")
//		public String home() {
//			return "paymentForm";
//		}
//
//		 @PostMapping(value = "/user/submitPaymentDetail/{d}")
//		    public ModelAndView getRedirect(@RequestParam(name = "USER_ID") String userId,
//		                                    @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
//		                                    @RequestParam(name = "ORDER_ID") String orderId) throws Exception {
//
//		        ModelAndView modelAndView = new ModelAndView("redirect:" + paymentDetails.getPaytmUrl());
//		        TreeMap<String, String> parameters = new TreeMap<>();
//		        paymentDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
//		        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
//		        parameters.put("EMAIL", env.getProperty("paytm.email"));
//		        parameters.put("ORDER_ID", orderId);
//		        parameters.put("TXN_AMOUNT", transactionAmount);
//		        parameters.put("USER_ID", userId);
//		        String checkSum = getCheckSum(parameters);
//		        parameters.put("CHECKSUMHASH", checkSum);
//		        modelAndView.addAllObjects(parameters);
//		        return modelAndView;
//		    }
//		 
//	        String paytmChecksum = "";
//
//		 @PostMapping(value = "/pgresponse")
//		    public String getResponseRedirect(HttpServletRequest request, Model model) {
//
//		        Map<String, String[]> mapData = request.getParameterMap();
//		        TreeMap<String, String> parameters = new TreeMap<String, String>();
//		        for (Entry<String, String[]> requestParamsEntry : mapData.entrySet()) {
//		            if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
//		                paytmChecksum = requestParamsEntry.getValue()[0];
//		            } else {
//		            	parameters.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
//		            }
//		        }
//		        String result;
//
//		        boolean isValideChecksum = false;
//		        System.out.println("RESULT : "+parameters.toString());
//		        try {
//		            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
//		            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
//		                if (parameters.get("RESPCODE").equals("01")) {
//		                    result = "Payment Successful";
//		                } else {
//		                    result = "Payment Failed";
//		                }
//		            } else {
//		                result = "Checksum mismatched";
//		            }
//		        } catch (Exception e) {
//		            result = e.toString();
//		        }
//		        model.addAttribute("result",result);
//		        parameters.remove("CHECKSUMHASH");
//		        model.addAttribute("parameters",parameters);
//		        return "payment-detail";
//		    }
//
//		    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
//		        return PaytmChecksum.verifySignature(parameters,
//		                paymentDetails.getMerchantKey(), paytmChecksum);
//		    }
//		private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
//			return PaytmChecksum.generateSignature(parameters, paymentDetails.getMerchantKey());
//		}
//		
//	
//
//
//}
