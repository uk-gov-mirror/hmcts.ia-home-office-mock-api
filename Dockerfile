ARG APP_INSIGHTS_AGENT_VERSION=3.4.13

# Application image

FROM hmctspublic.azurecr.io/base/java:17-distroless

COPY lib/AI-Agent.xml /opt/app/
COPY build/libs/ia-home-office-mock-api.jar /opt/app/

EXPOSE 8098
CMD [ "ia-home-office-mock-api.jar" ]
