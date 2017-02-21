function [ ] = Packet_dataRate_distribution()

%% initialize
networkdata = importfile1('C:/Wireless-Packets-Analysis/matlab_based_analysis/networkData.txt');

%% Main function
packet = 1;                                                          %start packet
fid = fopen('packet_dataRate_distribution.txt','w');

for m = 1:10                                                        %find the packet which has different dsr and src with the previous packet in the next m packets.
    packet = packet+1;
    if (ismember(networkdata{packet,1},networkdata(packet-1,1)) && ismember(networkdata(packet,2),networkdata(packet-1,2)) )
    else 
        src = networkdata(packet,1);
        dst = networkdata(packet,2);
        packetsizelist = num2cell(0);                    %initialize for every cicle

        %find the packet which has the same dst and src address 
        j = 1;
        for i = 1:length(networkdata)
            if (ismember(networkdata(i,1),src) && ismember(networkdata(i,2),dst))
                packetsizelist(j) = networkdata(i,5);
                j = j + 1;
            end
        end

        %figure out the probability distribution regarding to the packetsize
        list = cell2mat(packetsizelist);
        list = sort(list);
        probability = num2cell(0);                          %initialize for every cicle
        probability(1) = num2cell(1);
        packetsize = num2cell(0);                         %initialize for every cicle
        packetsize(1) = num2cell(list(1));
        
        %the distribution
        p = 1;
        for i = 2 : length(list)
            if (list(i) == list(i-1))
                probability(p) = num2cell(probability{p} + 1);
            else
                p = p+1;
                packetsize(p) = num2cell(list(i));
                probability(p) = num2cell(1);
            end 
        end

        for i = 1:length(packetsize)
            probability{i} = probability{i}/length(list);
        end
        
        %% visualize
        figure
        stem(cell2mat(packetsize),cell2mat(probability),'r*');
        title('Distribution of Data Rate');
        xlabel('Data Rate');
        ylabel('Probability');    
        
       %% Output to .txt file
        for i = 1:length(packetsize)
            fprintf(fid, '%4.0f  %f \n',packetsize{i},probability{i});
        end   
        fprintf(fid,'\n');

    end
    
end
        
fclose(fid);

end

