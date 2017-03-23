file = fopen('C:/wireless_packets_analysis/matlab_based_analysis/1s_number_of_nodes_689705.txt');
C = textscan(file,'%f %f\n');
n = 0;
for i = 1:length(C{1})
    n = i * C{2}(i) +n;
end
n
