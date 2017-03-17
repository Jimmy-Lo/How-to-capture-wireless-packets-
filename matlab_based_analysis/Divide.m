function [ outputData ] = Divide( inputData )
%divide the inputData into segments

    time_epoch = 1;   %for different time_epoch
       
    times_list = num2cell(0);                      %record the number of sources as time_epoch elapse.
    times_list(1) = num2cell(1);
    src = num2cell(0);
    src{1} = inputData(1,1); 
              
    %main body
    for i = 1:length(inputData)                    %read all the packets until the end
            T = strsplit(inputData{i,5},' ');
            packet_time = str2double(strsplit(T{2},':'));
        
            %compute the time_epoch which the packet+i belonged          
            time_span = (packet_time(1)-start_time(1))*3600 + (packet_time(2)-start_time(2))*60 + (packet_time(3)-start_time(3));
           
            n = floor(time_span/time_epoch);          % n denotes the interval number of the packet belongs to.
            
            if (length(times_list) < n+1)                         %do when beyond the exsiting time_epoch. 
               
                src = num2cell(0);
                src{1} = networkdata(i,1);                  %record the different src of the given dst in one time epoch.
                times_list(n+1) = num2cell(1);
                
            else                                                            %do when in the exsting time epoch         
                
                p = 0;                                                      %sign tag
                ds = cell2mat(networkdata(i,1));
                for k = 1:length(src)                                %whether the src is the same as the existing srcs in the time epoch.
                    sr = cell2mat(src{k});
                    if (isequal(ds,sr))
                        p = 1;
                    end            
                end
                
                if p == 1                                                    %if not, then add the src to the src set and add the times_list(n).
                else
                    src{length(src)+1} = networkdata(i,1);
                    times_list(n+1) = num2cell(times_list{n+1} + 1);
                end
               
            end
           
    end

end

