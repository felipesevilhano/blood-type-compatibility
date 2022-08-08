package com.kamila.model;

import com.kamila.exception.BloodAnalysisFailed;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BloodClinic {
    public static final Map<BloodType, List<BloodType>> donorCompatibilityMap;
    public static final Map<BloodType, List<BloodType>> receiverCompatibilityMap;

    static {
        donorCompatibilityMap = Map.of(
                BloodType.A_POSITIVE, List.of(BloodType.A_POSITIVE, BloodType.AB_POSITIVE),
                BloodType.O_POSITIVE, List.of(BloodType.O_POSITIVE, BloodType.A_POSITIVE, BloodType.B_POSITIVE, BloodType.AB_POSITIVE),
                BloodType.B_POSITIVE, List.of(BloodType.B_POSITIVE, BloodType.AB_POSITIVE),
                BloodType.AB_POSITIVE, List.of(BloodType.AB_POSITIVE),
                BloodType.A_NEGATIVE, List.of(BloodType.A_POSITIVE, BloodType.A_NEGATIVE, BloodType.AB_POSITIVE, BloodType.AB_NEGATIVE),
                BloodType.O_NEGATIVE, Arrays.stream(BloodType.values()).collect(Collectors.toList()),
                BloodType.B_NEGATIVE, List.of(BloodType.B_POSITIVE, BloodType.B_NEGATIVE, BloodType.AB_POSITIVE, BloodType.AB_NEGATIVE),
                BloodType.AB_NEGATIVE, List.of(BloodType.AB_POSITIVE, BloodType.AB_NEGATIVE)
        );

        receiverCompatibilityMap = Map.of(
                BloodType.A_POSITIVE, List.of(BloodType.A_POSITIVE, BloodType.A_NEGATIVE, BloodType.O_POSITIVE, BloodType.O_NEGATIVE),
                BloodType.O_POSITIVE, List.of(BloodType.O_POSITIVE, BloodType.O_NEGATIVE),
                BloodType.B_POSITIVE, List.of(BloodType.B_POSITIVE, BloodType.B_NEGATIVE, BloodType.O_POSITIVE, BloodType.O_NEGATIVE),
                BloodType.AB_POSITIVE, Arrays.stream(BloodType.values()).collect(Collectors.toList()),
                BloodType.A_NEGATIVE, List.of(BloodType.A_NEGATIVE, BloodType.O_NEGATIVE),
                BloodType.O_NEGATIVE, List.of(BloodType.O_NEGATIVE),
                BloodType.B_NEGATIVE, List.of(BloodType.B_NEGATIVE, BloodType.O_NEGATIVE),
                BloodType.AB_NEGATIVE, List.of(BloodType.AB_NEGATIVE, BloodType.A_NEGATIVE, BloodType.B_NEGATIVE, BloodType.O_NEGATIVE)
        );
    }

    public List<BloodType> analyze(Donor donor) {
        if(donor == null || donor.getBloodType() == null) {
            throw new BloodAnalysisFailed("Donor or blood type not informed.");
        }

        return donorCompatibilityMap.get(donor.getBloodType());
    }

    public List<BloodType> analyze(Receiver receiver) {
        if(receiver == null || receiver.getBloodType() == null) {
            throw new BloodAnalysisFailed("Receiver or blood type not informed.");
        }

        return receiverCompatibilityMap.get(receiver.getBloodType());
    }
}
