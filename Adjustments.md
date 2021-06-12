Package Service

1. Get package by TTN
2. Get List of User packages
3. Get list of all packages by Deparment
    - only for department_to
    - sorted by status(Arrived)
    - support filtering(weight(менше заданої), reciever_phone, deliver_date_start, deliver_date_finish)
4. Swagger

Fee calculation
Scheduled async job

Fee Calculations
1. Create In Separate Service
2. Scheduled each day at 8 P.M
3. Logic: For each package that in status=Delivered we calculating fee (getting from proprties file)
Condition: Fee calculation must start from 3d day of packcage keeping.
