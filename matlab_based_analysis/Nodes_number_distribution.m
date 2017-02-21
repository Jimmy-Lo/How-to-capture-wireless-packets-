function [  ] = Nodes_number_distribution(  )

%% initialize
networkdata = importfile('C:/Wireless-Packets-Analysis/matlab_based_analysis/networkData.txt');
packet = 1;                                                          % start packet.
time_epoch = 1;
fid = fopen('Nodes_number_distribution.txt','w');

%% Main function
for m = 1:10                                                 %find the packet which has different dsr with the previous packet in the next m packets.
% for time_epoch = 1:10:40
    
    packet = packet+1;
    if (ismember(networkdata(packet,2),networkdata(packet-1,2)) )
    else
        
        %initialize process.
        dst = networkdata(packet,2);
        times_list = num2cell(0);
        times_list(1) = num2cell(0);                      %record the number of sources as time_epoch elapse.
        src = num2cell(0);
        src{1} = networkdata(packet,1); 
        
        % find the first packet which has the same dsr.
        i = 1;
        while 1
            if (ismember(networkdata(i,2),dst))
                T = strsplit(networkdata{i,4},' ');
                start_time = str2double(strsplit(T{2},':'));
                times_list(1) = num2cell(1);
                break
            end
            i = i+1;
        end
        
        %main body
        for i = 1:length(networkdata)                    %read all the packets until the end
            if(ismember(networkdata(i,2),dst))      %for all the packet i which has the same dst.

                T = strsplit(networkdata{i,4},' ');
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
                    for k = 1:length(src)                                %whether the src is the same as the existing srcs in the time epoch.
                        sr = cell2mat(src{k});
                        ds = cell2mat(networkdata(i,1));
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


        % distribution of the number of sources for a specific dst in an time_epoch.
        number_of_sources_list = sort(cell2mat(times_list)); 
        x_list = 0;        
        y_list = 0;                                                    %initialize for every loop
        x_list(1) = number_of_sources_list(1);
        y_list(1) = 1;
  

        %compute the frequency distribution of the number_of_sources_list
        k=1;
        for i = 1: length(number_of_sources_list)-1
            if number_of_sources_list(i) == number_of_sources_list(i+1)
                y_list(k) =y_list(k) + 1;
            else
                k = k+1;
                x_list(k) = number_of_sources_list(i+1);
                y_list(k) = 1;
            end
        end

        %compute the probability distribution of the y_list.
        sum = 0;
        for i = 1:length(y_list)
            sum = sum + y_list(i);
        end
        for i = 1:length(y_list)
            y_list(i) = y_list(i) / sum;
        end


        % visualize
        figure
        bar(x_list,y_list,'b');
        title('Variation of the number of sources for a Specific Node');
        xlabel('Number of sources');
        ylabel('Probability');


        % Output to .txt file
        for i = 1:length(x_list)
            fprintf(fid, '%8.0f %8.3f \n',x_list(i),y_list(i));
        end
        fprintf(fid,'\n');
        
    end
    
end

% end
fclose(fid);
end

