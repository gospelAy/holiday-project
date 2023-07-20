package com.example.Election.models;

public enum Party {
        PARTY_APC("Party APC", "Candidate BOLABA"),
        PARTY_PDP("Party PDP", "Candidate ATIKU"),
        PARTY_LP("Party LP", "Candidate PETER_OBI");

        private final String partyName;
        private final String candidateName;

        Party(String partyName, String candidateName) {
            this.partyName = partyName;
            this.candidateName = candidateName;
        }

        public String getPartyName() {
            return partyName;
        }

        public String getCandidateName() {
            return candidateName;
        }
    }


